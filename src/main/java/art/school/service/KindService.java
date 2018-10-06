package art.school.service;


import art.school.entity.Kind;

public interface KindService extends MainServiceInterface<Kind> {

    void toggleAktiv(int id);

}
