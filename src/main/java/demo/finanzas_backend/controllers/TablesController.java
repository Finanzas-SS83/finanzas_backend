package demo.finanzas_backend.controllers;

import demo.finanzas_backend.entities.Tables;
import demo.finanzas_backend.entities.users;
import demo.finanzas_backend.service.IUserService;
import demo.finanzas_backend.service.ItablesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tables", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Tables", description = "Table Management Endpoints")
public class TablesController {
    private final ItablesService tablesService;
    private final IUserService usersService;
    public TablesController(ItablesService tablesService, IUserService usersService) {
        this.tablesService = tablesService;
        this.usersService = usersService;
    }

    @GetMapping("")
    public ResponseEntity<List<Tables>> findAllTables(){
        try {
            List<Tables> tables = tablesService.getAll();
            if(tables.size()>0)
                return new ResponseEntity<>(tables, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tables> findTableById(@PathVariable("id") Long id){
        try{
            Tables table = tablesService.getById(id);
            if(table != null)
                return new ResponseEntity<>(table, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tables> deleteTable(@PathVariable("id") Long id){
        try{
            Tables tableDelete = tablesService.getById(id);
            if(tableDelete != null){
                tablesService.delete(id);
                return new ResponseEntity<>(tableDelete, HttpStatus.OK);
            }
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/{User_id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tables> createTable( @PathVariable("User_id")Long User_id,@RequestBody Tables table){
        try{
            users user = usersService.getById(User_id);
            table.setId_user(user);
            Tables tableCreate = tablesService.save(table);
            return ResponseEntity.status(HttpStatus.CREATED).body(tableCreate);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
