package test.botscrew.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import test.botscrew.model.Lector;
import test.botscrew.repo.DepartmentRepository;
import test.botscrew.service.DepartmentService;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private static final String NO_EMPLOYEE_MESSAGE = "No employees are registered in this department - {0}";
    private static final String EMPTY_MESSAGE = "Empty Department name!";
    private static final String DEPARTMENT_NOT_EXIST_MESSAGE = "The department {0} does not exist, or its head has not yet been appointed";

    @Override
    public String getHeadOfDepartment(String departmentName) {
        if (Strings.isBlank(departmentName)) {
            return EMPTY_MESSAGE;
        }
        return  departmentRepository.findHeadOfDepartmentByDepartmentName(departmentName)
                .map(l -> MessageFormat.format("Head of {0} department is {1} {2}", departmentName, l.getFirstname(), l.getLastname()))
                .orElse(MessageFormat.format(DEPARTMENT_NOT_EXIST_MESSAGE, departmentName));
    }

    @Override
    public String getLectorsStatistic(String departmentName) {
        if (Strings.isBlank(departmentName)) {
            return EMPTY_MESSAGE;
        }
        List<Lector> lectors = departmentRepository.findPersonnelByDepartmentName(departmentName);
        if(CollectionUtils.isEmpty(lectors)) {
            return MessageFormat.format(NO_EMPLOYEE_MESSAGE, departmentName);
        }
        return lectors.stream()
                .collect(groupingBy(Lector::getDegree))
                .entrySet().stream()
                .map(es -> MessageFormat.format("{0} - {1}", es.getKey().getStringValue(), es.getValue().size()))
                .collect(joining("\n"));
    }

    @Override
    public String getLectorsAverageSalary(String departmentName) {
        if (Strings.isBlank(departmentName)) {
            return EMPTY_MESSAGE;
        }
        List<Lector> lectors = departmentRepository.findPersonnelByDepartmentName(departmentName);
        if(CollectionUtils.isEmpty(lectors)) {
            return MessageFormat.format(NO_EMPLOYEE_MESSAGE, departmentName);
        }
        return MessageFormat.format("The average salary of {0} is {1}", departmentName, lectors.stream()
                .map(Lector::getSalary)
                .mapToDouble(BigDecimal::doubleValue)
                .average().orElse(0));
    }

    @Override
    public String getCountOfEmployee(String departmentName) {
        if (Strings.isBlank(departmentName)) {
            return EMPTY_MESSAGE;
        }
        List<Lector> lectors = departmentRepository.findPersonnelByDepartmentName(departmentName);
        if(CollectionUtils.isEmpty(lectors)) {
            return MessageFormat.format(NO_EMPLOYEE_MESSAGE, departmentName);
        }
        return MessageFormat.format("{0}", lectors.size());
    }
}
