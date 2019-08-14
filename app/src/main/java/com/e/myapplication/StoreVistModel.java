package com.e.myapplication;

public class StoreVistModel {

    private String date, store_name,growth_degrowth,rocetragets,anybtlsupportrequired,anybillbusterrequired,
    Sm_asm_vacancy,additionalcashtills,parking,fire_exit,lift,Ac,pending_project_job,any_fixture_requiremnent;

    StoreVistModel(String date, String store_name,String growth_degrowth, String rocetragets,String anybtlsupportrequired,
                 String  anybillbusterrequired ,String Sm_asm_vacancy, String additionalcashtills, String  parking,
                   String fire_exit,String lift, String Ac, String pending_project_job,String any_fixture_requiremnent)
    {

            this.date = date;
            this.store_name = store_name;
            this.growth_degrowth = growth_degrowth;
            this.rocetragets = rocetragets;
            this.anybtlsupportrequired= anybtlsupportrequired;
            this.anybillbusterrequired = anybillbusterrequired;
            this.Sm_asm_vacancy = Sm_asm_vacancy;
            this.additionalcashtills = additionalcashtills;
            this.parking = parking;
            this.fire_exit=fire_exit;
            this.lift=lift;
            this.Ac=Ac;
            this.pending_project_job=pending_project_job;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getGrowth_degrowth() {
        return growth_degrowth;
    }

    public void setGrowth_degrowth(String growth_degrowth) {
        this.growth_degrowth = growth_degrowth;
    }

    public String getRocetragets() {
        return rocetragets;
    }

    public void setRocetragets(String rocetragets) {
        this.rocetragets = rocetragets;
    }

    public String getAnybtlsupportrequired() {
        return anybtlsupportrequired;
    }

    public void setAnybtlsupportrequired(String anybtlsupportrequired) {
        this.anybtlsupportrequired = anybtlsupportrequired;
    }

    public String getAnybillbusterrequired() {
        return anybillbusterrequired;
    }

    public void setAnybillbusterrequired(String anybillbusterrequired) {
        this.anybillbusterrequired = anybillbusterrequired;
    }

    public String getSm_asm_vacancy() {
        return Sm_asm_vacancy;
    }

    public void setSm_asm_vacancy(String sm_asm_vacancy) {
        Sm_asm_vacancy = sm_asm_vacancy;
    }

    public String getAdditionalcashtills() {
        return additionalcashtills;
    }

    public void setAdditionalcashtills(String additionalcashtills) {
        this.additionalcashtills = additionalcashtills;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getFire_exit() {
        return fire_exit;
    }

    public void setFire_exit(String fire_exit) {
        this.fire_exit = fire_exit;
    }

    public String getLift() {
        return lift;
    }

    public void setLift(String lift) {
        this.lift = lift;
    }

    public String getAc() {
        return Ac;
    }

    public void setAc(String ac) {
        Ac = ac;
    }

    public String getPending_project_job() {
        return pending_project_job;
    }

    public void setPending_project_job(String pending_project_job) {
        this.pending_project_job = pending_project_job;
    }

    public String getAny_fixture_requiremnent() {
        return any_fixture_requiremnent;
    }

    public void setAny_fixture_requiremnent(String any_fixture_requiremnent) {
        this.any_fixture_requiremnent = any_fixture_requiremnent;
    }
}
