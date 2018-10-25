package modele;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Path;

public class GenerateurPDF {
    
    // https://www.tutorialspoint.com/pdfbox/pdfbox_quick_guide.htm
    // https://pdfbox.apache.org/docs/2.0.12/javadocs/
    // https://uncloud.univ-nantes.fr/index.php/apps/onlyoffice/108682143
    public static void creerFichierPDF(Etudiant etudiant, Path path) throws IOException {
        PDDocument document = new PDDocument();

        final float WIDTH = 612f;
        final float HEIGHT = 792f;
        final float BORDER_SIZE = 30f;

        PDPage page = new PDPage();

        /*PDRectangle pageRect = page.getBBox();

        // 612 : 792
        System.out.println(pageRect.getWidth() + " : " + pageRect.getHeight());*/

        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();

        contentStream.setFont(PDType1Font.TIMES_BOLD, 14);

        contentStream.newLineAtOffset(WIDTH / 2f - 100f, HEIGHT - 150f);

        contentStream.showText("Avis de poursuite d'études");

        contentStream.newLineAtOffset(-(WIDTH / 2f) + 100f + BORDER_SIZE, -50f);

        contentStream.showText("Résultats de la promotion  (moyenne des trois premiers semestres S1, S2, S3) :");

        contentStream.endText();

        contentStream.setStrokingColor(Color.black);
        contentStream.setLineWidth(2f);

        contentStream.addRect(BORDER_SIZE + 10f, HEIGHT - 220f, WIDTH - BORDER_SIZE * 2f, -300f);

        contentStream.stroke();

        contentStream.setLineWidth(1f);

        contentStream.addRect(BORDER_SIZE + 10f, HEIGHT - 240f, WIDTH - BORDER_SIZE * 2f, -270f);

        contentStream.stroke();

        contentStream.close();

        document.addPage(page);

        document.save(path.toFile());
        document.close();
    }
}
