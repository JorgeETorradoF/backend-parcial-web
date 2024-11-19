package com.example.ProyectoWeb.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProyectoWeb.dto.ContratoDTO;
import com.example.ProyectoWeb.model.Contratos;
import com.example.ProyectoWeb.repository.ContratosRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratoService {

    @Autowired
    private ContratosRepository contratosRepository;

    @Autowired
    private ModelMapper modelMapper;
 
    public ContratoDTO crearContrato(ContratoDTO contratoDTO) {
        Contratos contrato = modelMapper.map(contratoDTO, Contratos.class);
        Contratos contratoGuardado = contratosRepository.save(contrato);
        return modelMapper.map(contratoGuardado, ContratoDTO.class);
    }

    public ContratoDTO actualizarContrato(Integer id, ContratoDTO contratoDTO) {
        Optional<Contratos> contratoOptional = contratosRepository.findById(id);

        if (contratoOptional.isEmpty()) {
            throw new RuntimeException("Contrato con ID " + id + " no encontrado.");
        }

        Contratos contrato = contratoOptional.get();
        contrato.setIdentificador(contratoDTO.getIdentificador());
        contrato.setPrecio(contratoDTO.getPrecio());
        contrato.setNombreContratante(contratoDTO.getNombreContratante());
        contrato.setDocumentoContratante(contratoDTO.getDocumentoContratante());
        contrato.setNombreContratantista(contratoDTO.getNombreContratantista());
        contrato.setDocumentoContratantista(contratoDTO.getDocumentoContratantista());
        contrato.setFechaInicial(contratoDTO.getFechaInicial());
        contrato.setFechaFinal(contratoDTO.getFechaFinal());

        Contratos contratoActualizado = contratosRepository.save(contrato);
        return modelMapper.map(contratoActualizado, ContratoDTO.class);
    }


    public void eliminarContrato(Integer id) {
        if (!contratosRepository.existsById(id)) {
            throw new RuntimeException("Contrato con ID " + id + " no encontrado.");
        }
        contratosRepository.deleteById(id);
    }


    public List<ContratoDTO> listarContratos() {
        List<Contratos> contratos = contratosRepository.findAll();
        return contratos.stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                .collect(Collectors.toList());
    }


    public ContratoDTO obtenerContratoPorId(Integer id) {
        Contratos contrato = contratosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato con ID " + id + " no encontrado."));
        return modelMapper.map(contrato, ContratoDTO.class);
    }
}
