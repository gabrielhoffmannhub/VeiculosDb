package com.example.veiculosdb.controller;

import com.example.veiculosdb.dto.CarroRequestDTO;
import com.example.veiculosdb.dto.CarroResponseDTO;
import com.example.veiculosdb.model.Carro;
import com.example.veiculosdb.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
@RequiredArgsConstructor
public class CarroController {

    private final CarroService carroService;

    @PostMapping
    public ResponseEntity<Void> criarCarro(@RequestBody CarroRequestDTO dto) {
        Carro carro = new Carro();
        carro.setMarca(dto.getMarca());
        carro.setModelo(dto.getModelo());
        carro.setAnoFabricacao(dto.getAnoFabricacao());
        carro.setPlaca(dto.getPlaca());
        carro.setTipo(dto.getTipo());
        carro.setValorMercado(dto.getValorMercado());

        carroService.salvar(carro);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Carro>> listarTodos() {
        return ResponseEntity.ok(carroService.listarTodos());
    }

    @GetMapping("/{placa}")
    public ResponseEntity<CarroResponseDTO> buscarPorPlaca(@PathVariable String placa) {
        return carroService.buscarPorPlaca(placa)
                .map(carro -> {
                    CarroResponseDTO response = new CarroResponseDTO();
                    response.setId(carro.getId());
                    response.setMarca(carro.getMarca());
                    response.setModelo(carro.getModelo());
                    response.setAnoFabricacao(carro.getAnoFabricacao());
                    response.setPlaca(carro.getPlaca());
                    response.setTipo(carro.getTipo());
                    response.setValorMercado(carro.getValorMercado());
                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }



    @PutMapping("/{placa}")
    public ResponseEntity<Carro> atualizarCarro(@PathVariable String placa, @RequestBody CarroRequestDTO dto) {
        return carroService.atualizarPorPlaca(placa, dto)
                .map(carroAtualizado -> ResponseEntity.ok().body(carroAtualizado))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity<Void> deletarCarro(@PathVariable String placa) {
        if (carroService.deletarPorPlaca(placa)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
