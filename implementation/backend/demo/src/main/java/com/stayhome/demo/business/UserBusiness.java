package com.stayhome.demo.business;

import com.stayhome.demo.data.StayHome;
import com.stayhome.demo.repositories.StayHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserBusiness {

    @Autowired
    private StayHomeRepository repository;

    /**
     * Create: Guarda un nuevo user
     * @param newUser
     * @return StayHome guardado
     */
    public StayHome create(StayHome newUser){
        return repository.save(newUser);

    }
    /**
     * Read: Obtiene todos los users
     * @return users
     *
     */
    public List<StayHome> findAll(){

        return new ArrayList<>(repository.findAll());
    }

    /**
     * Update: Actualiza un user existente
     * @param item
     * @return User actualizado
     */
    public StayHome update(StayHome item){
        StayHome a = repository.findById(item.getUser_id()).get();
        if(a != null){
            return repository.save(item);
        }
        return null;
    }

    /**cd
     * Delete: Elimina un user existente
     * @param user_id
     */
    public void delete(BigInteger user_id){

        repository.deleteById(user_id);
    }
}
