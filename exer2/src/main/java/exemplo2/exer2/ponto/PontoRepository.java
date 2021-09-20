package exemplo2.exer2.ponto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long> {
//    @Query(nativeQuery = true, value = "select * from ponto where funcionario_id = :id ")
//    List<Ponto> findAllByFuncionarioId(@Param("id") Long id);


    @Query(nativeQuery = true, value = "SELECT * FROM PONTO WHERE DATE > :date AND ATRASO IS TRUE and funcionario_id = :id")
    List<Ponto> buscarListaDePontos(@Param("date") Date date, @Param("id") Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM PONTO WHERE DATE > :date and funcionario_id = :id ")
    List<Ponto> buscarPrimeiroPonto(@Param("date") Date date, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE PONTO SET ATRASO = FALSE WHERE DATE > :date AND ATRASO  = TRUE AND funcionario_id = :id")
    public void liberarUsuario(@Param("date") Date date, @Param("id") Long id);

}
