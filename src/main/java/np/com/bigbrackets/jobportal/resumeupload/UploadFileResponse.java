package np.com.bigbrackets.jobportal.resumeupload;

public class UploadFileResponse {

    private String filePath;
    private String fileType;
    private Long size;

    public UploadFileResponse(){

    }

    public UploadFileResponse(String filePath, String fileType, Long size){
        this.filePath = filePath;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
