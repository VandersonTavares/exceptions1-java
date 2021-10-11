package model.exceptions;
                                    /*se extends Exception são obrigados a serem tratados, caso RuntimeException, não precisaria ser tratados
                                    podemos remover a propagação throws DomainException, mas sempre utilzar catch para capturar as exceções casoc contrário
                                    o programa quebra.
                                    */
public class DomainException extends Exception{
    private static final long serialVersionUID =1L;
    
    //permite que eu possa instanciar a exceção personalizada passando uma msg
    //a msg fica armazenada dentro da exception
    public DomainException(String msg){
        super(msg);
    }
}
