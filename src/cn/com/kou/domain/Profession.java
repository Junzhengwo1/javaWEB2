package cn.com.kou.domain;

/**
 * @author JIAJUN KOU
 *
 * 对应Profession表封装的数据
 */
public class Profession {
    private int p_id;
    private String professionName;
    private int physicalAttackGrow;
    private int magicAttackGrow;
    private int physicalDefenseGrow;
    private int magicDefenseGrow;
    private int hpGrow;
    private int manaGrow;

    @Override
    public String toString() {
        return "Profession{" +
                "p_id=" + p_id +
                ", professionName='" + professionName + '\'' +
                ", physicalAttackGrow=" + physicalAttackGrow +
                ", magicAttackGrow=" + magicAttackGrow +
                ", physicalDefenseGrow=" + physicalDefenseGrow +
                ", magicDefenseGrow=" + magicDefenseGrow +
                ", hpGrow=" + hpGrow +
                ", manaGrow=" + manaGrow +
                '}';
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public int getPhysicalAttackGrow() {
        return physicalAttackGrow;
    }

    public void setPhysicalAttackGrow(int physicalAttackGrow) {
        this.physicalAttackGrow = physicalAttackGrow;
    }

    public int getMagicAttackGrow() {
        return magicAttackGrow;
    }

    public void setMagicAttackGrow(int magicAttackGrow) {
        this.magicAttackGrow = magicAttackGrow;
    }

    public int getPhysicalDefenseGrow() {
        return physicalDefenseGrow;
    }

    public void setPhysicalDefenseGrow(int physicalDefenseGrow) {
        this.physicalDefenseGrow = physicalDefenseGrow;
    }

    public int getMagicDefenseGrow() {
        return magicDefenseGrow;
    }

    public void setMagicDefenseGrow(int magicDefenseGrow) {
        this.magicDefenseGrow = magicDefenseGrow;
    }

    public int getHpGrow() {
        return hpGrow;
    }

    public void setHpGrow(int hpGrow) {
        this.hpGrow = hpGrow;
    }

    public int getManaGrow() {
        return manaGrow;
    }

    public void setManaGrow(int manaGrow) {
        this.manaGrow = manaGrow;
    }
}
