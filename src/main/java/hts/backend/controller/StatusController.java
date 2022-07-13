package hts.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador para determinar el estatus del servicio.
 * 
 * @author rafaelnagano
 *
 */
@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class StatusController {

    /**
     * Message.
     */
    private static final String MESSAGE_STATUS = "HEALTHY";

    /**
     * Metodo para pasar el Unhealthy.
     *
     * @return    OK.
     */
    @GetMapping("/")
    public final String status() {
        return MESSAGE_STATUS;
    }

    /**
     * Metodo para pasar el Unhealthy.
     *
     * @return    OK.
     */
    @GetMapping("/alta-pacientes/")
    public final String statusHealth() {
        return MESSAGE_STATUS;
    }

}