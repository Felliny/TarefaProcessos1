package View;

import Controller.RedesController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        RedesController redesCont = new RedesController();
        String os = redesCont.os();
        int opcao= 0;


        while (opcao != 9){
            opcao= Integer.parseInt(JOptionPane.showInputDialog("MENU \n 1 - Mostrar ip \n 2 - Mostrar ping \n 9 - Finalizar"));
            switch (opcao){
                case 1:
                    if (os.contains("Windows")){
                        String process = "IPCONFIG";
                        redesCont.chamaip(process);
                    }
                    else {
                        String process = "ifconfig";
                        redesCont.chamaip(process);
                    }
                    break;
                case 2:
                    if (os.contains("Windows")){
                        String process2 = "PING -4 -n 10 www.google.com.br";
                        redesCont.chamaping(process2);
                    }
                    else {
                        String process2 = "ping -4 -c 10 www.google.com.br";
                        redesCont.chamaping(process2);
                    }
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcão Inválida!");
            }
        }
    }
}
