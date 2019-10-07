package test.test.persistence;

import java.io.Serializable;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;
 
public class MyEntity implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyEntity() {
    }
 
    private byte[] data;
 
    public byte[] getData() {
    	System.out.println("entity here");
    	System.out.println(data);
        return data;
    }
 
    @FormParam("uploadedFile")   
    @PartType("application/octet-stream")
    public void setData(byte[] data) {
        this.data = data;
    }
 
}