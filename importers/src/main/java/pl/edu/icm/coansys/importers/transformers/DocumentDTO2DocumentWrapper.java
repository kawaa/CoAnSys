/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.icm.coansys.importers.transformers;

import com.google.protobuf.ByteString;
import java.io.IOException;
import pl.edu.icm.coansys.importers.models.DocumentDTO;
import pl.edu.icm.coansys.importers.models.DocumentProtos.DocumentWrapper;

/**
 *
 * @author akawa
 */
public class DocumentDTO2DocumentWrapper {
    
    public static String translateToString(DocumentDTO docDTO) throws IOException {
        DocumentWrapper dw = translate(docDTO);
        return dw.toByteString().toString();
    }

    public static DocumentWrapper translate(DocumentDTO docDTO) {
        DocumentWrapper.Builder dw = DocumentWrapper.newBuilder();
        dw.setRowId(RowComposer.composeRow(docDTO));
        dw.setDocumentMetadata(docDTO.getDocumentMetadata());
        dw.setMediaContainer(docDTO.getMediaConteiner());
        return dw.build();
    }
    
}
