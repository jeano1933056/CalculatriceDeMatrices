package classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    public Label labelResultats;
    public TextArea firstMatrice;
    public TextArea deuxiemeMatrice;

    public void afficherResultatAddition() {
        StringBuilder area = new StringBuilder();

        String m = firstMatrice.getText();
        String m2 = deuxiemeMatrice.getText();
        String[] c = m.split(System.lineSeparator());
        String[] c2 = m2.split(System.lineSeparator());
        for (int i = 0; i < c.length; i++) {
            String[] v = c[i].split(" ");
            String[] v2 = c2[i].split(" ");
            int[][] matrice = new int[c.length][v.length];
            int[][] matrice2 = new int[c2.length][v2.length];
            for (int j = 0; j < v.length; j++) {
                int valeur = Integer.parseInt(v[j]);
                int valeur2 = Integer.parseInt(v2[j]);
                matrice[i][j] = valeur;
                matrice2[i][j] = valeur2;
                matrice[i][j] = matrice[i][j] + matrice2[i][j];
                area.append(matrice[i][j]).append(" ");
            }
            labelResultats.setText(area.toString());
            area.append(System.lineSeparator());
        }
        System.out.println(area.toString());
    }

    public void afficherResultatSoustraction() {
        StringBuilder area = new StringBuilder();

        String m = firstMatrice.getText();
        String m2 = deuxiemeMatrice.getText();
        String[] c = m.split(System.lineSeparator());
        String[] c2 = m2.split(System.lineSeparator());
        for (int i = 0; i < c.length; i++) {
            String[] v = c[i].split(" ");
            String[] v2 = c2[i].split(" ");
            int[][] matrice = new int[c.length][v.length];
            int[][] matrice2 = new int[c2.length][v2.length];
            for (int j = 0; j < v.length; j++) {
                int valeur = Integer.parseInt(v[j]);
                int valeur2 = Integer.parseInt(v2[j]);
                matrice[i][j] = valeur;
                matrice2[i][j] = valeur2;
                matrice[i][j] = matrice[i][j] - matrice2[i][j];
                area.append(matrice[i][j]).append(" ");
            }
            labelResultats.setText(area.toString());
            area.append(System.lineSeparator());
        }
        System.out.println(area.toString());
    }

    public void afficherProduitHadamard() {
        StringBuilder area = new StringBuilder();

        String m = firstMatrice.getText();
        String m2 = deuxiemeMatrice.getText();
        String[] c = m.split(System.lineSeparator());
        String[] c2 = m2.split(System.lineSeparator());
        for (int i = 0; i < c.length; i++) {
            String[] v = c[i].split(" ");
            String[] v2 = c2[i].split(" ");
            int[][] matrice = new int[c.length][v.length];
            int[][] matrice2 = new int[c2.length][v2.length];
            for (int j = 0; j < v.length; j++) {
                int valeur = Integer.parseInt(v[j]);
                int valeur2 = Integer.parseInt(v2[j]);
                matrice[i][j] = valeur;
                matrice2[i][j] = valeur2;
                matrice[i][j] = matrice[i][j] * matrice2[i][j];
                area.append(matrice[i][j]).append(" ");
            }
            labelResultats.setText(area.toString());
            area.append(System.lineSeparator());
        }
        System.out.println(area.toString());
    }

    public void afficherTransposition() {
        StringBuilder area = new StringBuilder();

        String mat1 = firstMatrice.getText();
        String[] m = mat1.split(System.lineSeparator());
        String[] n = m[0].split(" ");

        int[][] matrice = new int[m.length][n.length];
        int[][] matriceResultante = new int[n.length][m.length];

        for (int i = 0; i < m.length; i++) {
            String[] k = m[i].split(" ");
            for (int j = 0; j < k.length; j++) {
                int valeur = Integer.parseInt(k[j]);
                matrice[i][j] = valeur;
            }
        }

        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < m.length; j++) {
                matriceResultante[i][j] = matrice[j][i];
                area.append(matriceResultante[i][j]).append(" ");
            }
            labelResultats.setText(area.toString());
            area.append(System.lineSeparator());
        }
        System.out.println(area.toString());
    }

    public void afficherDeterminant() {
        String[] l = firstMatrice.getText().split(System.lineSeparator());

        int[][] matrice = new int[3][3];
        for(int i = 0; i < matrice.length; i++ ) {
            for (int j = 0; j < matrice[i].length; j++) {
                String[] m = l[i].split(" ");
                int valeur = Integer.parseInt(m[j]);
                matrice[i][j] = valeur;
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int det1 = (matrice[0][0]*matrice[1][1]*matrice[2][2]) +
                (matrice[0][1]*matrice[1][2]*matrice[2][0]) +
                (matrice[0][2]*matrice[1][0]*matrice[2][1]);
        int det2 = (matrice[2][0]*matrice[1][1]*matrice[0][2]) +
                (matrice[2][1]*matrice[1][2]*matrice[0][0]) +
                (matrice[2][2]*matrice[1][0]*matrice[0][1]);
        int determinant = det1 - det2;

        System.out.println("Déterminant : " + determinant);
        labelResultats.setText("Déterminant : " + determinant);
    }

    public void afficherProduitMatriciel() {
        StringBuilder area = new StringBuilder();

        String l = firstMatrice.getText();
        String l2 = deuxiemeMatrice.getText();
        String[] m = l.split(System.lineSeparator());
        String[] n = m[0].split(" ");
        String[] n2 = l2.split(System.lineSeparator());
        String[] p = m[1].split(" ");
        int[][] matrice = new int[m.length][n.length];
        int[][] matrice2 = new int[n2.length][p.length];
        int[][] matriceResultante = new int[m.length][p.length];

        for (int i = 0; i < m.length; i++ ) {
            String[] k = m[i].split(" ");
            for (int j = 0; j < n.length; j++) {
                int valeur = Integer.parseInt(k[j]);
                matrice[i][j] = valeur;
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < n2.length; i++ ) {
            String[] k = n2[i].split(" ");
            for (int j = 0; j < p.length; j++) {
                int valeur = Integer.parseInt(k[j]);
                matrice2[i][j] = valeur;
                System.out.print(matrice2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < m.length; i++ ) {
            for (int j = 0; j < p.length; j++) {
                for (int k = 0; k < n.length; k++) {
                    matriceResultante[i][j] += (matrice[i][k]*matrice2[k][j]);
                }
                System.out.print(matriceResultante[i][j] + " ");
                area.append(matriceResultante[i][j]).append(" ");
            }
            System.out.println();
            labelResultats.setText(area.toString());
            area.append(System.lineSeparator());
        }
        System.out.println();
    }

    public void afficherProduitVectoriel() {
        StringBuilder area = new StringBuilder();

        String z = firstMatrice.getText();
        String l = deuxiemeMatrice.getText();

        int[] matrice = new int[3];
        int[] matrice2 = new int[3];
        int[] matriceResultante = new int[3];
        String[] m = z.split(" ");
        String[] w = l.split(" ");

        for (int i = 0; i < matrice.length; i++ ) {
            int valeur = Integer.parseInt(m[i]);
            matrice[i] = valeur;
            System.out.print(matrice[i] + " ");
            area.append(matrice[i]).append(" ");
        }
        area.append(System.lineSeparator());
        System.out.println();

        for (int i = 0; i < matrice2.length; i++ ) {
            int valeur = Integer.parseInt(w[i]);
            matrice2[i] = valeur;
            System.out.print(matrice2[i] + " ");
            area.append(matrice2[i]).append(" ");
        }
        area.append(System.lineSeparator());
        System.out.println();

        matriceResultante [0] = (matrice[1]*matrice2[2]) - (matrice[2]*matrice2[1]);
        matriceResultante [1] = (matrice[2]*matrice2[0]) - (matrice[0]*matrice2[2]);
        matriceResultante [2] = (matrice[0]*matrice2[1]) - (matrice[1]*matrice2[0]);

        for (int j : matriceResultante) {
            System.out.print(j + " ");
            area.append(j).append(" ");
        }
        System.out.println();
        area.append(System.lineSeparator());
        labelResultats.setText(area.toString());
    }

    public void afficherInverse() {
        StringBuilder area = new StringBuilder();

        String matr = firstMatrice.getText();
        String[] l = matr.split(System.lineSeparator());

        double[][] matrice = new double[3][3];

        for (int i = 0; i < matrice.length; i++ ) {
            for (int j = 0; j < matrice[i].length; j++) {
                String[] m = l[i].split(" ");
                int valeur = Integer.parseInt(m[j]);
                matrice[i][j] = valeur;
            }
        }

        double det1 = (matrice[0][0]*matrice[1][1]*matrice[2][2]) +
                (matrice[0][1]*matrice[1][2]*matrice[2][0]) +
                (matrice[0][2]*matrice[1][0]*matrice[2][1]);
        double det2 = (matrice[2][0]*matrice[1][1]*matrice[0][2]) +
                (matrice[2][1]*matrice[1][2]*matrice[0][0]) +
                (matrice[2][2]*matrice[1][0]*matrice[0][1]);
        double determinant = det1 - det2;
        double[][] adj = new double[3][3];
        adj[0][0] = (matrice[1][1]*matrice[2][2]) - (matrice[1][2] * matrice[2][1]);
        adj[0][1] = (matrice[1][0]*matrice[2][2]) - (matrice[1][2] * matrice[2][0]);
        adj[0][2] = (matrice[1][0]*matrice[2][1]) - (matrice[1][1] * matrice[2][0]);
        adj[1][0] = (matrice[0][1]*matrice[2][2]) - (matrice[0][2] * matrice[2][1]);
        adj[1][1] = (matrice[0][0]*matrice[2][2]) - (matrice[0][2] * matrice[2][0]);
        adj[1][2] = (matrice[0][0]*matrice[2][1]) - (matrice[0][1] * matrice[2][0]);
        adj[2][0] = (matrice[0][1]*matrice[1][2]) - (matrice[0][2] * matrice[1][1]);
        adj[2][1] = (matrice[0][0]*matrice[1][2]) - (matrice[0][2] * matrice[1][0]);
        adj[2][2] = (matrice[0][0]*matrice[1][1]) - (matrice[0][1] * matrice[1][0]);
        double[][] matriceResulante = new double[3][3];

        for(int i = 0; i < adj.length; i++ ) {
            for (int j = 0; j < adj[i].length; j++) {
                matrice[i][j] = adj[j][i];
                if (determinant != 0) {
                    matriceResulante[i][j] = matrice[i][j] * (1 / determinant);
                }
                else {
                    matriceResulante[i][j] = 0;
                }
                area.append(matriceResulante[i][j]).append(" ");
            }
            labelResultats.setText(area.toString());
            area.append(System.lineSeparator());
        }
        labelResultats.setText(area.toString());
        System.out.println(area.toString());
    }

    public void afficherMultiParNombre() {
        StringBuilder area = new StringBuilder();

        String resultat = firstMatrice.getText();
        String mat1 = deuxiemeMatrice.getText();
        String[] c = mat1.split(System.lineSeparator());

        for (int i = 0; i < c.length; i++ ) {
            String[] v = c[i].split(" ");
            int[][] matrice = new int[c.length][v.length];
            int constante = Integer.parseInt(resultat);
            for (int j = 0; j < matrice[i].length; j++) {
                int valeur = Integer.parseInt(v[j]);
                matrice[i][j] = valeur;
                matrice[i][j] = matrice[i][j] * constante;
                area.append(matrice[i][j]).append(" ");
            }
            labelResultats.setText(area.toString());
            area.append(System.lineSeparator());
        }
        labelResultats.setText(area.toString());
        System.out.println(area.toString());
    }

    public void goToSoustractionScene(ActionEvent actionEvent) throws IOException {
        Parent soustractionParent = FXMLLoader.load(getClass().getResource("soustraction.fxml"));
        Scene soustractionScene = new Scene(soustractionParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(soustractionScene);
        window.show();
    }

    public void goToAdditionScene(ActionEvent actionEvent) throws IOException {
        Parent additionParent = FXMLLoader.load(getClass().getResource("addition.fxml"));
        Scene additionScene = new Scene(additionParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(additionScene);
        window.show();
    }

    public void goToHadamardScene(ActionEvent actionEvent) throws IOException {
        Parent hadamardParent = FXMLLoader.load(getClass().getResource("produitHadamard.fxml"));
        Scene hadamardScene = new Scene(hadamardParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(hadamardScene);
        window.show();
    }

    public void goToTranspositionScene(ActionEvent actionEvent) throws IOException {
        Parent transpositionParent = FXMLLoader.load(getClass().getResource("transposition.fxml"));
        Scene transpositionScene = new Scene(transpositionParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(transpositionScene);
        window.show();
    }

    public void goToDeterminantScene(ActionEvent actionEvent) throws IOException {
        Parent determinantParent = FXMLLoader.load(getClass().getResource("determinant.fxml"));
        Scene determinantScene = new Scene(determinantParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(determinantScene);
        window.show();
    }

    public void goToProduitMatricielScene(ActionEvent actionEvent) throws IOException {
        Parent produitMatricielParent = FXMLLoader.load(getClass().getResource("produitMatriciel.fxml"));
        Scene produitMatricielScene = new Scene(produitMatricielParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(produitMatricielScene);
        window.show();
    }

    public void goToProduitVectorielScene(ActionEvent actionEvent) throws IOException {
        Parent produitVectorielParent = FXMLLoader.load(getClass().getResource("produitVectoriel.fxml"));
        Scene produitVectorielScene = new Scene(produitVectorielParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(produitVectorielScene);
        window.show();
    }

    public void goToInverseScene(ActionEvent actionEvent) throws IOException {
        Parent inverseParent = FXMLLoader.load(getClass().getResource("inverse.fxml"));
        Scene inverseScene = new Scene(inverseParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(inverseScene);
        window.show();
    }

    public void goToMultiParNombre(ActionEvent actionEvent) throws IOException {
        Parent multiParNombreParent = FXMLLoader.load(getClass().getResource("multiParNombre.fxml"));
        Scene multiParNombreScene = new Scene(multiParNombreParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(multiParNombreScene);
        window.show();
    }

    public void goToTutoriel(ActionEvent actionEvent) throws IOException{
        Parent tutorielParent = FXMLLoader.load(getClass().getResource("tutoriel.fxml"));
        Scene tutorielScene = new Scene(tutorielParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(tutorielScene);
        window.show();
    }

    public void goToRemerciements(ActionEvent actionEvent) throws IOException{
        Parent remerciementsParent = FXMLLoader.load(getClass().getResource("remerciements.fxml"));
        Scene remerciementsScene = new Scene(remerciementsParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(remerciementsScene);
        window.show();
    }

    public void goToMenu(ActionEvent actionEvent) throws IOException {
        Parent menuParent = FXMLLoader.load(getClass().getResource("menu.fxml"));
        Scene menuScene = new Scene(menuParent);

        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(menuScene);
        window.show();
    }
}