import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        StackDinamica sdParenteses = new StackDinamica();
        StackDinamica sdColchetes = new StackDinamica();
        StackDinamica sdChaves = new StackDinamica();
        boolean verificação = true;

        System.out.println("Digite a expressão:");
        String palavra = scan.next();
        String vet[] = palavra.split("");
        for (int i = 0; i < vet.length; i++) {
            if (vet[i].equals("(")) {
                sdParenteses.push(vet[i]);
            }
            if (vet[i].equals(")")) {
                if (sdParenteses.isEmpyt()) {
                    verificação = false;
                    break;
                } else
                    sdParenteses.pop();
            }

            if (vet[i].equals("[")) {
                sdColchetes.push(vet[i]);
            }
            if (vet[i].equals("]")) {
                if (sdColchetes.isEmpyt()) {
                    verificação = false;
                    break;
                } else
                    sdColchetes.pop();
            }

            if (vet[i].equals("{")) {
                sdChaves.push(vet[i]);
            }
            if (vet[i].equals("}")) {
                if (sdChaves.isEmpyt()) {
                    verificação = false;
                    break;
                } else
                    sdChaves.pop();
            }
        }
        if (sdChaves.isEmpyt()) {
            if (sdParenteses.isEmpyt() && sdColchetes.isEmpyt() && sdChaves.isEmpyt() && verificação) {
                System.out.println("A expressão se encontra correta");
            } else {
                System.out.println("A expressão não se encontra correta");
            }
        }
    }
}