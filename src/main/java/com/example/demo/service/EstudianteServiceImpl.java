package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository iEstudianteRepository;

	@Override
	public EstudianteTO guardar(EstudianteTO estudianteTO) {
		// TODO Auto-generated method stub
		this.iEstudianteRepository.insertar(this.convertir(estudianteTO));
		
		Estudiante e =this.iEstudianteRepository.buscarPorCedula(estudianteTO.getCedula());
		
		return this.convertirTO(e);
	}

	private Estudiante convertir(EstudianteTO estudianteTO) {
		Estudiante e = new Estudiante();
		e.setNombre(estudianteTO.getNombre());
		e.setApellido(estudianteTO.getApellido());
		e.setCedula(estudianteTO.getCedula());

		return e;
	}
	
	private EstudianteTO convertirTO(Estudiante estudianteTO) {
		EstudianteTO e = new EstudianteTO();
		e.setId(estudianteTO.getId());
		e.setNombre(estudianteTO.getNombre());
		e.setApellido(estudianteTO.getApellido());
		e.setCedula(estudianteTO.getCedula());

		return e;
	}
	


}
