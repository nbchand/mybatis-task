package com.nbchand.mbt.mapper;

import com.nbchand.mbt.pojo.BankResponse;
import com.nbchand.mbt.pojo.CustomerPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Narendra
 * @version 1.0
 * @since 2022-07-20
 */
@Mapper
public interface BankMapper {

    //xml based
    BankResponse findBankById(Integer id);
    List<BankResponse> findAllBank();

    //annotation based
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "location", column = "location"),
            @Result(property = "customers", column = "id", many = @Many(select = "getCustomerListFromBank"))
    })
    @Select("select b.id             as \"id\",\n" +
            "       b.name           as \"name\",\n" +
            "       b.location       as \"location\"\n" +
            "from bank b\n" +
            "where b.id = #{id}")
    BankResponse findBankByIdAnnotation(Integer id);

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "location", column = "location"),
            @Result(property = "customers", column = "id", many = @Many(select = "getCustomerListFromBank"))
    })
    @Select("select b.id             as \"id\",\n" +
            "       b.name           as \"name\",\n" +
            "       b.location       as \"location\"\n" +
            "from bank b")
    List<BankResponse> findAllBankAnnotation();

    @Results(
            value = {
                    @Result(property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "location", column = "location"),
                    @Result(property = "accountNumber", column = "account_number")
            }
    )
    @Select("select id, name, location, account_number\n" +
            "from customer c\n" +
            "where bank_id=#{parentId}")
    List<CustomerPojo> getCustomerListFromBank();
}
