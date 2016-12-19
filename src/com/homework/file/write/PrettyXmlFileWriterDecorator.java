package com.homework.file.write;

import com.homework.domain.Ranking;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.util.List;

/**
 * @author Viktoras Kisielis
 */
public class PrettyXmlFileWriterDecorator implements FileWriter {

    private static final String STYLESHEET_XSLT = "stylesheet.xslt";
    private static final String PRETTY_EXTENSION = "html";

    private XmlFileWriter xmlFileWriter = new XmlFileWriter();

    @Override
    public File writeResult(List<Ranking> rankings, String outputPath) {
        File xmlFile = xmlFileWriter.writeResult(rankings, outputPath);
        File prettyFile = changeExtension(xmlFile.getAbsolutePath());
        try {
            RankingListWrapper wrapper = new RankingListWrapper(rankings);
            JAXBContext jaxbContext = JAXBContext.newInstance(RankingListWrapper.class, Ranking.class);
            // Create Transformer
            TransformerFactory tf = TransformerFactory.newInstance();
            StreamSource xslt = new StreamSource(STYLESHEET_XSLT);
            Transformer transformer = tf.newTransformer(xslt);
            // Source
            JAXBSource source = new JAXBSource(jaxbContext, wrapper);
            StreamResult result = new StreamResult(prettyFile);
            // Transform
            transformer.transform(source, result);
        } catch (JAXBException | TransformerException e) {
            System.out.println(String.format("Error while trying create output file %s with message %s", outputPath, e.getMessage()));
        }

        return null;
    }

    private File changeExtension(String filePath) {
        int index = filePath.indexOf(".");
        return new File(filePath.substring(0, index + 1)+PRETTY_EXTENSION);
    }
}
