public class EmprestimoNãoExisteException extends RuntimeException {
    public EmprestimoNãoExisteException() {
        super();
    }

    public EmprestimoNãoExisteException(String msg) {
        super(msg);
    }
}