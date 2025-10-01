package br.com.filmix.api.exception;

import br.com.filmix.api.dto.ErroDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // (Erro 404)
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> tratarRecursoNaoEncontrado(RecursoNaoEncontradoException ex, HttpServletRequest request) {
        ErroDTO erro = new ErroDTO(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    // (Erro 400)
    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<ErroDTO> tratarRegraDeNegocio(RegraDeNegocioException ex, HttpServletRequest request) {
        ErroDTO erro = new ErroDTO(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    // (Erro 401)
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErroDTO> tratarCredenciaisInvalidas(BadCredentialsException ex, HttpServletRequest request) {
        ErroDTO erro = new ErroDTO(HttpStatus.UNAUTHORIZED, "Credenciais inválidas.", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(erro);
    }

    // (Erro 400)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDTO> tratarValidacao(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String mensagem = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        ErroDTO erro = new ErroDTO(HttpStatus.BAD_REQUEST, mensagem, request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}
