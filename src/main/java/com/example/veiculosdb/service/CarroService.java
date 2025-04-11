package com.example.veiculosdb.service;

import com.example.veiculosdb.dto.CarroRequestDTO;
import com.example.veiculosdb.model.Carro;
import com.example.veiculosdb.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroRepository carroRepository;

    public Carro salvar(Carro carro) {
        return carroRepository.save(carro);
    }

    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    public Optional<Carro> buscarPorPlaca(String placa) {
        return carroRepository.findByPlaca(placa);
    }

    public Optional<Carro> atualizarPorPlaca(String placa, CarroRequestDTO dto) {
        return carroRepository.findByPlaca(placa).map(carro -> {
            carro.setMarca(dto.getMarca());
            carro.setModelo(dto.getModelo());
            carro.setAnoFabricacao(dto.getAnoFabricacao());
            carro.setTipo(dto.getTipo());
            carro.setValorMercado(dto.getValorMercado());
            return carroRepository.save(carro);
        });
    }

    public boolean deletarPorPlaca(String placa) {
        return carroRepository.findByPlaca(placa).map(carro -> {
            carroRepository.delete(carro);
            return true;
        }).orElse(false);
    }
}
