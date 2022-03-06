package com.memsource.task.domain.base;

import com.memsource.task.dto.base.BaseApiDTO;
import com.memsource.task.exception.MemsourceException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.modelmapper.ModelMapper;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity <T extends BaseEntity, D extends BaseApiDTO>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

    private boolean isDeleted;

    public D toDTO () {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;

        D d = null;
        try {
            d = ((Class<D>) paramType.getActualTypeArguments()[1]).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new MemsourceException(e.getMessage(), e.getCause());
        } catch (InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        //InstUnitTypeDTO institutionUnitTypeDTO = new InstUnitTypeDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(this, d);
        return d;
    }

    public T fromDTO(D obj) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(obj, this);
        return (T) this;
    }
}
