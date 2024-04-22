package cn.oza.logistic.ssm.pojo;

public class BasicData {
    private Long baseId;

    private String baseName;

    private String baseDesc;

    private Long parentId;

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName == null ? null : baseName.trim();
    }

    public String getBaseDesc() {
        return baseDesc;
    }

    public void setBaseDesc(String baseDesc) {
        this.baseDesc = baseDesc == null ? null : baseDesc.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "BasicData{" +
                "baseId=" + baseId +
                ", baseName='" + baseName + '\'' +
                ", baseDesc='" + baseDesc + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}