package model;

import java.io.Serializable;

/**
 *
 * @author John Phillips
 */
public class Bug implements Serializable {

    private int id;
    private String game;
    private String operatingSystem;
    private String pythonVersion;
    private String problemDesc;
    private String notes;

    public Bug() {
        id = 0;
        game = "fallingSkies";
        operatingSystem = "Windows 10";
        pythonVersion = "2.7.10";
        problemDesc = "Does not exit";
        notes = "No errors, game runs fine";
    }

    public Bug(int id, String game, String operatingSystem, String pythonVersion, String problemDesc, String notes) {
        this.id = id;
        this.game = game;
        this.operatingSystem = operatingSystem;
        this.pythonVersion = pythonVersion;
        this.problemDesc = problemDesc;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getPythonVersion() {
        return pythonVersion;
    }

    public void setPythonVersion(String pythonVersion) {
        this.pythonVersion = pythonVersion;
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String inHTMLRowFormat() {
        return "<tr><td>" + id + "</td>"
                
                + "<td>" + operatingSystem + "</td>"
                + "<td>" + pythonVersion + "</td>"
                + "<td>" + problemDesc + "</td>"
                + "<td>" + notes + "</td></tr>\n";
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", game=" + game + ", operatingsystem="
                + operatingSystem + ", pythonversion=" + pythonVersion + ", problemdescription=" + problemDesc
                + ", notes=" + notes + '}';
    }
}
