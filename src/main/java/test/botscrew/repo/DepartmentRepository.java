package test.botscrew.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.botscrew.model.Department;
import test.botscrew.model.Lector;

import java.util.List;
import java.util.Optional;


public interface DepartmentRepository extends JpaRepository<Department, Long> {
     @Query("select d.headOfDepartment from Department d where d.name = :departmentName")
     Optional<Lector> findHeadOfDepartmentByDepartmentName(String departmentName);

     @Query("select d.personnel from Department d where d.name = :departmentName")
     List<Lector> findPersonnelByDepartmentName(String departmentName);
}
