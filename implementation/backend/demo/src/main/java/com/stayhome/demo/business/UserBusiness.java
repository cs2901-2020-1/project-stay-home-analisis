package com.stayhome.demo.business;

import com.stayhome.demo.data.User;
import com.stayhome.demo.repositories.UserRepository;
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
    private UserRepository repository;

    /**
     * Create: Guarda un nuevo user
     * @param newUser
     * @return StayHome guardado
     */
    public User create(User newUser){
        return repository.save(newUser);

    }
    /**
     * Read: Obtiene todos los users
     * @return users
     *
     */
    public List<User> findAll(){

        return new ArrayList<>(repository.findAll());
    }

    /**
     * Update: Actualiza un user existente
     * @param item
     * @return User actualizado
     */
    public User update(User item){
        User a = repository.findById(item.getUser_id()).get();
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
