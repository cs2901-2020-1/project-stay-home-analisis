package com.stayhome.demo.business;

import com.stayhome.demo.data.User;
import com.stayhome.demo.data.Article;
import com.stayhome.demo.repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
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
    public User update(@NotNull User item){
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
        /**
         * Eliminar articulo con usuario
         * Eliminar ese articulo de article_pack
         * Eliminar playlist con user_id
         * Eliminar tabla likes_by_article
         * **/
        repository.deleteLikes_by_user(user_id);//Eliminar  likes_by_article
        for(BigInteger i : repository.allArticles_by_user(user_id)){
            repository.deleteArticlebypack_by_user(i);//Eliminar ese articulo de article_pack
        }
        repository.deleteArticlepack_by_user(user_id);//Eliminar playlist con user_id
        repository.delete_article_by_user_id(user_id);//Eliminar articulo con usuario
        repository.deleteById(user_id);
    }
}
