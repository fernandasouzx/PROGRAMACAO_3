package trabalho;

public class CampoVazioException extends Exception {
    public CampoVazioException(String campo){
        super("O campo '" + campo + "' deve ter algo.");   
    }
}