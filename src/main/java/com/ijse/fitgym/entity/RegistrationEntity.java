package com.ijse.fitgym.entity;

import com.ijse.fitgym.enums.ActiveAndDeActive;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fg_registration")
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    long registrationId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "branchId", referencedColumnName = "branchId")
    private BranchEntity branchEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "packageId", referencedColumnName = "packageId")
    private PackageEntity packageEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
    private MemberEntity memberEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adminId", referencedColumnName = "adminId")
    private AdminEntity adminEntity;
    private ActiveAndDeActive state;

    public RegistrationEntity() {
    }

    public RegistrationEntity(BranchEntity branchEntity, PackageEntity packageEntity, MemberEntity memberEntity, AdminEntity adminEntity, ActiveAndDeActive state) {
        this.branchEntity = branchEntity;
        this.packageEntity = packageEntity;
        this.memberEntity = memberEntity;
        this.adminEntity = adminEntity;
        this.state = state;
    }

    public long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(long registrationId) {
        this.registrationId = registrationId;
    }

    public BranchEntity getBranchEntity() {
        return branchEntity;
    }

    public void setBranchEntity(BranchEntity branchEntity) {
        this.branchEntity = branchEntity;
    }

    public PackageEntity getPackageEntity() {
        return packageEntity;
    }

    public void setPackageEntity(PackageEntity packageEntity) {
        this.packageEntity = packageEntity;
    }

    public MemberEntity getMemberEntity() {
        return memberEntity;
    }

    public void setMemberEntity(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }

    public AdminEntity getAdminEntity() {
        return adminEntity;
    }

    public void setAdminEntity(AdminEntity adminEntity) {
        this.adminEntity = adminEntity;
    }

    public ActiveAndDeActive getState() {
        return state;
    }

    public void setState(ActiveAndDeActive state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RegistrationEntity{" +
                "registrationId=" + registrationId +
                ", branchEntity=" + branchEntity +
                ", packageEntity=" + packageEntity +
                ", memberEntity=" + memberEntity +
                ", adminEntity=" + adminEntity +
                ", state=" + state +
                '}';
    }
}
