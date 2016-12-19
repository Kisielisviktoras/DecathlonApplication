package com.homework.file.write;

import com.homework.domain.Ranking;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

/**
 * @author Viktoras Kisielis
 */
public class XmlFileWriter implements FileWriter {

    @Override
    public File writeResult(List<Ranking> rankings, String outputPath) {
        File outputFile = new File(outputPath);
        try {
            outputFile.getParentFile().mkdirs();
            RankingListWrapper wrapper = new RankingListWrapper(rankings);
            File file = new File(outputPath);
            JAXBContext jaxbContext = JAXBContext.newInstance(RankingListWrapper.class, Ranking.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(wrapper, file);

        } catch (JAXBException e) {
            System.out.println(String.format("Error while trying create output file %s with message %s", outputPath, e.getMessage()));
        }

        return outputFile;
    }
}
