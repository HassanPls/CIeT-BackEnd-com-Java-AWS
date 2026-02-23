package poo.collections_e_classes_uteis.Ex1;

import java.util.stream.LongStream;

public enum Operation {

    SUM(n -> LongStream.of(n).reduce(0, Long::sum), "+"), 
    SUBTRACTION(n -> LongStream.of(n).reduce(0, (n1, n2) -> n1 - n2), "-");

    private final Calc operationCallback;
    private final String sinal;

    private Operation(Calc operationCallback, String sinal) {
        this.operationCallback = operationCallback;
        this.sinal = sinal;
    }

    public Calc getOperationCallback() {
        return operationCallback;
    }

    public String getSinal() {
        return sinal;
    }


}

