package poo.classe_e_encapsulamento.Ex2;

public class Car {
    private boolean isOn = false;
    private int acceleration = 0;
    private int gear = 0;

    public void on() {
        if (isOn) {
            System.out.println("O carro já está ligado");
            return;
        }
        System.out.println("Carro ligado");
        isOn = true;
    }

    public void off() {
        if (!isOn) {
            System.out.println("O carro já está desligado");
            return;
        }
        if (gear > 0 && acceleration > 0) {
            System.out.println("Você não pode desligar o carro, desacelere e coloque no ponto morto.");
            return;
        }
        System.out.println("Carro desligado");
        isOn = false;
    }

    public void accelerate() {
        if (!isOn) {
            System.out.println("O carro não está ligado, você não pode fazer nada.");
            return;
        } else if (gear == 0) {
            System.out.println("A marcha está na zero, você não pode fazer nada.");
            return;
        }

        if (!gearAllowToAccelerate()) {
            System.out.println("Você não pode acelerar com essa marcha");
            return;
        }
        
        if (acceleration <= 120) {
            System.out.println("Acelerando");
            this.acceleration++;
        } else {
            System.out.println("Você já está na velocidade máxima!");
        }
    }

    public void decelerate() {
        if (!isOn) {
            System.out.println("O carro não está ligado, você não pode fazer nada.");
            return;
        } else if (gear == 0) {
            System.out.println("A marcha está na zero, você não pode fazer nada.");
            return;
        }
        
        if (acceleration >= 0) {
            System.out.println("Desacelerando");
            this.acceleration--;
        } else {
            System.out.println("Você já está na velocidade mínima!");
        }
    }

    public void turnLeftOrRight(String turnLeftOrRight) {
        if (!isOn) {
            System.out.println("O carro não está ligado, você não pode fazer nada.");
            return;
        } else if (gear == 0) {
            System.out.println("A marcha está na zero, você não pode fazer nada.");
            return;
        }

        if (acceleration > 0 && acceleration <= 40) {
            System.out.println("Virando à " + turnLeftOrRight);
        }
    }

    public void changeGear(int change) {
        if (change < 0 || change > 6) {
            System.out.println("Você não pode mudar a marcha para esse valor");
        }

        if (change == (this.gear - 1) || change == (this.gear + 1)) {
            this.gear = change;
            System.out.println("Marcha mudada para " + change);
        } else {
            System.out.println("Você não pode mudar a marcha para esse valor");
        }
    }

    public boolean gearAllowToAccelerate() {
        if (gear == 1 && acceleration <= 20) {
            return true;
        } else if (gear == 2 && acceleration <= 40) {
            return true;
        } else if (gear == 3 && acceleration <= 60) {
            return true;
        } else if (gear == 4 && acceleration <= 80) {
            return true;
        } else if (gear == 5 && acceleration <= 100) {
            return true;
        } else if (gear == 6 && acceleration <= 120) {
            return true;
        } else {
            return false;
        }
    }
}
