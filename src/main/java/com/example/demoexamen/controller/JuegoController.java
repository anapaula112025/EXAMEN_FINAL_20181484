package com.example.demoexamen.controller;

import com.example.demoexamen.entity.Juego;
import com.example.demoexamen.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class JuegoController {

    final DistribuidoraRepository distribuidoraRepository;
    final EditoraRepository editoraRepository;
    final GeneroRepository generoRepository;
    final JuegoRepository juegoRepository;
    final PlataformaRepository plataformaRepository;
    final SedeRepository sedeRepository;

    public JuegoController(DistribuidoraRepository distribuidoraRepository,
                           EditoraRepository editoraRepository, GeneroRepository generoRepository,
                           JuegoRepository juegoRepository, PlataformaRepository plataformaRepository,
                           SedeRepository sedeRepository) {
        this.distribuidoraRepository = distribuidoraRepository;
        this.editoraRepository = editoraRepository;
        this.generoRepository = generoRepository;
        this.juegoRepository = juegoRepository;
        this.plataformaRepository = plataformaRepository;
        this.sedeRepository = sedeRepository;
    }

    //@GetMapping("api/orders/listarjuegos")
    //public List<Juego> listaJuegos() {

        //return juegoRepository.findAll();

    //}

    @GetMapping("api/orders/listarjuegos")
    public ResponseEntity<HashMap<String, Object>> listarJuegos() {

        HashMap<String, Object> respuesta = new HashMap<>();

        respuesta.put("result", "success");
        respuesta.put("data", juegoRepository.findAll());
        return ResponseEntity.ok(respuesta);

    }

    @PostMapping("api/orders/juego")
    public ResponseEntity<HashMap<String, Object>> guardarJuego(
            @RequestBody Juego juego,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {

        HashMap<String, Object> responseJson = new HashMap<>();

        fetchId = true;

        juegoRepository.save(juego);

        responseJson.put("result", "success");
        if (fetchId) {
            responseJson.put("data", juego.getId());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(responseJson);
    }

    @PutMapping(value = {"api/orders/juego"})
    public ResponseEntity<HashMap<String, Object>> actualizar(Juego juegoRecibido) {

        HashMap<String, Object> responseMap = new HashMap<>();
        if(juegoRecibido.getId() !=null && juegoRecibido.getId() > 0){
            Optional<Juego> opt = juegoRepository.findById(juegoRecibido.getId());
            if(opt.isPresent()){
                juegoRepository.save(juegoRecibido);
                responseMap.put("result","success");
                responseMap.put("data", "updated_id:" + juegoRecibido.getId());
                return ResponseEntity.ok(responseMap);

            } else {
                responseMap.put("result", "error");
                responseMap.put("msg", "parámetros incorrectos");
                return ResponseEntity.badRequest().body(responseMap);

            }

        } else{
            responseMap.put("result", "error");
            responseMap.put("msg", "parámetros incorrectos");
            return ResponseEntity.badRequest().body(responseMap);
        }


    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, String>> gestionException(HttpServletRequest request) {
        HashMap<String, String> responseMap = new HashMap<>();
        if (request.getMethod().equals("POST") || request.getMethod().equals("PUT")) {
            responseMap.put("estado", "error");
            responseMap.put("msg", "Debe enviar un producto");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }






}
