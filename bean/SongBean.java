package bean;


public class SongBean {   
    private String songName;
    private String songPath;
    private String songSize;
    private int songHot;

    public SongBean(){

    }

    public SongBean(String name,String path,String size,int hot){
        songName = name;
        songPath = path;
        songSize = size;
        songHot = hot;
    }
    public void setHot(int hot){
        songHot = hot;
    }
    public int getHot(){
        return this.songHot;
    }
    public int getSongHot() {
        return songHot;
    }

    public String getSongName() {
        return songName;
    }

    public String getSongPath() {
        return songPath;
    }

    public String getSongSize() {
        return songSize;
    }

    public void setSongSize(String songSize) {
        this.songSize = songSize;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setSongHot(int songHot) {
        this.songHot = songHot;
    }

}
