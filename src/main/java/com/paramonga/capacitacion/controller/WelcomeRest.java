package com.paramonga.capacitacion.controller;

import com.paramonga.capacitacion.domain.DateUtils;
import com.paramonga.capacitacion.domain.Ejemplo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/welcomeRest")
public class WelcomeRest {

    @GetMapping(value = "/devuelveEjemplo", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Ejemplo> devuelveEjemplo() {
        Ejemplo ejemplo = new Ejemplo();
        ejemplo.setApellidos("Perez");
        ejemplo.setNombres("Juan");
        return Optional.ofNullable(ejemplo).map(bean -> new ResponseEntity<>(bean, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/devuelveEjemplo01/{ejemplo1}/{ejemplo2}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Ejemplo> devuelveEjemplo01(
            @PathVariable String ejemplo1,
            @PathVariable String ejemplo2) {
        Ejemplo ejemplo = new Ejemplo();
        ejemplo.setApellidos("Perez");
        ejemplo.setDireccion("Dirección de Prueba");
        ejemplo.setEmail("cbazalarlarosa@gmail.com");
        ejemplo.setNombres("Juan " + ejemplo1 + " " + ejemplo2);
        return Optional.ofNullable(ejemplo).map(bean -> new ResponseEntity<>(bean, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping(value = "/devuelveEjemploPost", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Ejemplo> devuelveEjemploPost(
            @RequestBody Ejemplo ejemplo) {
        ejemplo.setApellidos(ejemplo.getApellidos() + " FINAL");
        ejemplo.setApellidosNombres(ejemplo.getApellidos() + ", " + ejemplo.getNombres());
        return Optional.ofNullable(ejemplo).map(bean -> new ResponseEntity<>(bean, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/devuelveEjemplo02Post", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Ejemplo> devuelveEjemploPost02(
            @RequestBody Ejemplo ejemplo) {
        ejemplo.setApellidos(ejemplo.getApellidos() + " FINAL 02");
        ejemplo.setApellidosNombres(ejemplo.getApellidos() + ", " + ejemplo.getNombres());
        ejemplo.setRuc("1111111");
        return Optional.ofNullable(ejemplo).map(bean -> new ResponseEntity<>(bean, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping(value = "/devuelveFechaActual", produces = APPLICATION_JSON_VALUE)
    public String devuelveFechaActual() {
        Date fechaActual = DateUtils.obtenerFechaActual();
        String result = DateUtils.convertDateToString(fechaActual);
        return result;
    }

}
