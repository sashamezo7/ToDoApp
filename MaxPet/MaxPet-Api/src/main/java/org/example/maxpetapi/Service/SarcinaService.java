package org.example.maxpetapi.Service;

import org.example.maxpetapi.Models.Sarcina;
import org.example.maxpetapi.Response.Response;
import org.example.maxpetapi.entity.SarcinaEntity;
import org.example.maxpetapi.entity.UsersEntity;
import org.example.maxpetapi.repository.SarcinaRepository;
import org.springframework.stereotype.Service;
import org.example.maxpetapi.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SarcinaService {
    private final SarcinaRepository sarcinaRepository;
    private final UsersRepository usersRepository; // Adaugă repository pentru utilizatori

    public SarcinaService(SarcinaRepository sarcinaRepository, UsersRepository usersRepository) {
        this.sarcinaRepository = sarcinaRepository;
        this.usersRepository = usersRepository;
    }

    public Response adaugareSarcina(Sarcina sarcina) {
        try {

            UsersEntity user = usersRepository.findByUsername(sarcina.getUsername());
            if (user != null) {

                SarcinaEntity sarcinaEntity = new SarcinaEntity();
                sarcinaEntity.setUser(user);
                sarcinaEntity.setCerinta(sarcina.getCerinta());
                sarcinaEntity.setActiv(1);

                SarcinaEntity newSarcina = sarcinaRepository.save(sarcinaEntity);

                if (newSarcina != null) {
                    return new Response(200, "Sarcina adaugata");
                } else {
                    return new Response(100, "Sarcina nu a fost adaugata");
                }
            } else {
                return new Response(100, "Utilizatorul nu exista");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(100, "Sarcina failed");
        }
    }
    public Response deleteSarcinaById(int id) {
        try {
            Optional<SarcinaEntity> sarcinaEntity = sarcinaRepository.findById(id);
            if (sarcinaEntity.isPresent()) {
                sarcinaRepository.deleteById(id);
                return new Response(200, "Sarcina stearsa cu succes");
            } else {
                return new Response(100, "Sarcina nu exista");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(100, "Delete sarcina failed");
        }
    }
    public Response deleteCompletedSarcina(Sarcina sarcina) {
        try {
            UsersEntity user = usersRepository.findByUsername(sarcina.getUsername());
            if (user != null) {
                List<SarcinaEntity> sarcini = sarcinaRepository.findByUserAndActiv(user, 0);
                if (sarcini.isEmpty()) {
                    return new Response(100, "No completed tasks found for user");
                } else {
                    sarcinaRepository.deleteAll(sarcini);
                    return new Response(200, "Task Deleted");
                }
            } else {
                return new Response(100, "User does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(100, "Task deletion failed");
        }
    }
    public Response updateSarcinaActiv(Sarcina sarcina) {
        try {
            Optional<SarcinaEntity> optionalSarcinaEntity = sarcinaRepository.findById(sarcina.getId());
            if (optionalSarcinaEntity.isPresent()) {
                SarcinaEntity sarcinaEntity = optionalSarcinaEntity.get();
                sarcinaEntity.setActiv(sarcina.getActiv());
                sarcinaRepository.save(sarcinaEntity);
                return new Response(200, "Task Updated");
            } else {
                return new Response(100, "Fail to Update");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(100, "Fail to Update");
        }
    }
    public Response updateSarcinaCerinta(Sarcina sarcina) {
        try {
            Optional<SarcinaEntity> optionalSarcinaEntity = sarcinaRepository.findById(sarcina.getId());
            if (optionalSarcinaEntity.isPresent()) {
                SarcinaEntity sarcinaEntity = optionalSarcinaEntity.get();
                sarcinaEntity.setCerinta(sarcina.getCerinta());
                sarcinaRepository.save(sarcinaEntity);
                return new Response(200, "Task Updated");
            } else {
                return new Response(100, "Fail to Update");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(100, "Fail to Update");
        }
    }
    public Response sarcinaListCompletedLast(Sarcina sarcina) {
        List<SarcinaEntity> sarciniEntities = null;
        try {
            UsersEntity user = usersRepository.findByUsername(sarcina.getUsername());
            sarciniEntities = null;
            if (user != null) {
                sarciniEntities = sarcinaRepository.findByUserOrderByActivDesc(user);
                List<Sarcina> sarcini = new ArrayList<>();

                for (SarcinaEntity entity : sarciniEntities) {
                    Sarcina sar = new Sarcina();
                    sar.setId(entity.getId());
                    sar.setUsername(entity.getUser().getUsername());
                    sar.setCerinta(entity.getCerinta());
                    sar.setActiv(entity.getActiv());
                    sarcini.add(sar);
                }

                if (!sarcini.isEmpty()) {
                    return new Response(200, "Sarcini Gasite", sarciniEntities);
                } else {
                    return new Response(100, "Nu au fost gasite sarcini", sarciniEntities);
                }
            } else {
                return new Response(100, "Nu au fost gasite sarcini", sarciniEntities);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(100, "Nu au fost gasite sarcini", sarciniEntities);
        }
    }

    public Response SarcinaListOldestToNewest(Sarcina sarcina) {
        List<SarcinaEntity> sarciniEntities = null;
        try {
            UsersEntity user = usersRepository.findByUsername(sarcina.getUsername());
            sarciniEntities = null;
            if (user != null) {
                sarciniEntities = sarcinaRepository.findByUserOrderByActivAsc(user);
                List<Sarcina> sarcini = new ArrayList<>();

                for (SarcinaEntity entity : sarciniEntities) {
                    Sarcina sar = new Sarcina();
                    sar.setId(entity.getId());
                    sar.setUsername(entity.getUser().getUsername());
                    sar.setCerinta(entity.getCerinta());
                    sar.setActiv(entity.getActiv());
                    sarcini.add(sar);
                }

                if (!sarcini.isEmpty()) {
                    return new Response(200, "Sarcini Gasite", sarciniEntities);
                } else {
                    return new Response(100, "Nu au fost gasite sarcini", sarciniEntities);
                }
            } else {
                return new Response(100, "Nu au fost gasite sarcini", sarciniEntities);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(100, "Nu au fost gasite sarcini", sarciniEntities);
        }
    }


}

