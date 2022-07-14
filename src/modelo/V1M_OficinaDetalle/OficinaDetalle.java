public class OficinaDetalle {
    public int ofiIde;
    public String ofiCiu;
    public String ofiReg;
    public String ofiDir;
    public String ofiEmp;
    public int ofiObj;
    public String ofiVen;
    public String ofiEstReg;

    public OficinaDetalle(int ofiIde, String ofiCiu, String ofiReg, String ofiDir, String ofiEmp, int ofiObj,
            String ofiVen, String ofiEstReg) {
        this.ofiIde = ofiIde;
        this.ofiCiu = ofiCiu;
        this.ofiReg = ofiReg;
        this.ofiDir = ofiDir;
        this.ofiEmp = ofiEmp;
        this.ofiObj = ofiObj;
        this.ofiVen = ofiVen;
        this.ofiEstReg = ofiEstReg;
    }

    public OficinaDetalle() {
        this.ofiIde = -1;
        this.ofiCiu = "";
        this.ofiReg = "";
        this.ofiDir = "";
        this.ofiEmp = "";
        this.ofiObj = -1;
        this.ofiVen = "";
        this.ofiEstReg = "";
    }

    public int getOfiIde() {
        return ofiIde;
    }

    public void setOfiIde(int ofiIde) {
        this.ofiIde = ofiIde;
    }

    public String getOfiCiu() {
        return ofiCiu;
    }

    public void setOfiCiu(String ofiCiu) {
        this.ofiCiu = ofiCiu;
    }

    public String getOfiReg() {
        return ofiReg;
    }

    public void setOfiReg(String ofiReg) {
        this.ofiReg = ofiReg;
    }

    public String getOfiDir() {
        return ofiDir;
    }

    public void setOfiDir(String ofiDir) {
        this.ofiDir = ofiDir;
    }

    public String getOfiEmp() {
        return ofiEmp;
    }

    public void setOfiEmp(String ofiEmp) {
        this.ofiEmp = ofiEmp;
    }

    public int getOfiObj() {
        return ofiObj;
    }

    public void setOfiObj(int ofiObj) {
        this.ofiObj = ofiObj;
    }

    public String getOfiVen() {
        return ofiVen;
    }

    public void setOfiVen(String ofiVen) {
        this.ofiVen = ofiVen;
    }

    public String getOfiEstReg() {
        return ofiEstReg;
    }

    public void setOfiEstReg(String ofiEstReg) {
        this.ofiEstReg = ofiEstReg;
    }
}
