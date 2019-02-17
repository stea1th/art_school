package art.school.service;

import art.school.entity.Nachricht;

import java.util.List;

public interface NachrichtService extends MainServiceInterface<Nachricht> {

    List<Nachricht> getAllByThemaId(int id);
}
