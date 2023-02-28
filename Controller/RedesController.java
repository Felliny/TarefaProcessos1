package Controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

    public RedesController(){
        super();
    }

    //Retorna o S.O. que está em execução na máquina
    public String os(){
        String os = System.getProperty("os.name");//Nome do sistema
        String arch = System.getProperty("os.arch");//Arquitetura do sistema
        String version = System.getProperty("os.version");//Versão do sistema
        return os + " - V. "+ version +" - arch. "+ arch;
    }

    public void chamaip(String process){
        if (os().contains("Windows")){
            try{
                Process p = Runtime.getRuntime().exec(process);
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();
                while (linha != null){
                    if (linha.contains("Ethernet")){
                        System.out.println(linha);
                    }
                    if (linha.contains("IPv4")){
                        System.out.println(linha);
                    }
                    linha = buffer.readLine();
                }
                buffer.close();
                leitor.close();
                fluxo.close();

            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        else {
            try{
                Process p = Runtime.getRuntime().exec(process);
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();
                while (linha != null){
                    if (linha.contains("mtu")){
                        System.out.println(linha);

                    }
                    if (linha.contains("inet")){
                        String[] separa = linha.split(" ");
                        System.out.println("IPv4: "+ separa[1]);
                    }
                    linha = buffer.readLine();
                }
                buffer.close();
                leitor.close();
                fluxo.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void chamaping(String process2) {
        if (os().contains("Windows")) {
            try {
                Process p = Runtime.getRuntime().exec(process2);
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();
                while (linha != null){
                    if (linha.contains("Average")){
                        String[] separa = linha.split(" ");
                        System.out.println("média de ping: " +separa[12]);
                    }
                    linha = buffer.readLine();
                }
                buffer.close();
                leitor.close();
                fluxo.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            try {
                Process p = Runtime.getRuntime().exec(process2);
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();
                while (linha != null){
                    if (linha.contains("rtt")){
                        String[] separa = linha.split("/");
                        System.out.println("média de ping: " +separa[4]);
                    }
                    linha = buffer.readLine();
                }
                buffer.close();
                leitor.close();
                fluxo.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
