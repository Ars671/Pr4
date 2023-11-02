package com.example.cruddemo.controllers;

import javax.validation.Valid;

import com.example.cruddemo.models.*;
import com.example.cruddemo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    

    private final PostRepository postRepository;
    private final CotegoryRepository cotegoryRepository;
    private final SupplierRepository supplierRepository;
    private final WarehouseRepository warehouseRepository;
    private final ElectronicsRepository electronicsRepository;
    private final CantractRepository cantractRepository;
    private final SupplyRepository supplyRepository;

    @Autowired
    public CustomerController(PostRepository postRepository, CotegoryRepository cotegoryRepository, SupplierRepository supplierRepository, WarehouseRepository warehouseRepository, ElectronicsRepository electronicsRepository, CantractRepository cantractRepository, SupplyRepository supplyRepository) {
        this.postRepository = postRepository;
        this.cotegoryRepository = cotegoryRepository;
        this.supplierRepository = supplierRepository;
        this.warehouseRepository = warehouseRepository;
        this.electronicsRepository = electronicsRepository;
        this.cantractRepository = cantractRepository;
        this.supplyRepository = supplyRepository;
    }

    @GetMapping()
    public String dan(Model model){
        model.addAttribute("posts", postRepository.findAll());
        model.addAttribute("cotegorys", cotegoryRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("electronicss", electronicsRepository.findAll());
        model.addAttribute("cantracts", cantractRepository.findAll());
        model.addAttribute("supplys", supplyRepository.findAll());
        return "index";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newpost")
    public String showSignUpForm(Model model) {
        model.addAttribute("post",new Post());
        return "add-post";
    }


    @GetMapping("/editpost/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        model.addAttribute("post", post);
        return "update-post";
    }

    @GetMapping("/deletepost/{id}")
    public String deletepost(@PathVariable("id") int id, Model model) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid post Id:" + id));
        postRepository.delete(post);
        model.addAttribute("posts", postRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addpost")
    public String addPost(@Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-post";
        }

        postRepository.save(post);
        model.addAttribute("posts", postRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatepost/{id}")
    public String updatePost(@PathVariable("id") int id, @Valid Post post, BindingResult result, Model model) {
        if (result.hasErrors()) {
            post.setId(id);
            return "update-post";
        }

        postRepository.save(post);
        model.addAttribute("posts", postRepository.findAll());
        return "redirect:/";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newcotegory")
    public String showSignUpFormCotegory(Model model) {
        model.addAttribute("cotegory",new Cotegory());
        return "add-cotegory";
    }


    @GetMapping("/editcotegory/{id}")
    public String showUpdateFormCotegory(@PathVariable("id") int id, Model model) {
        Cotegory cotegory = cotegoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cotegory Id:" + id));
        model.addAttribute("cotegory", cotegory);
        return "update-cotegory";
    }

    @GetMapping("/deletecotegory/{id}")
    public String deleteCotegory(@PathVariable("id") int id, Model model) {
        Cotegory cotegory = cotegoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cotegory Id:" + id));
        cotegoryRepository.delete(cotegory);
        model.addAttribute("cotegorys", cotegoryRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addcotegory")
    public String addCotegory(@Valid Cotegory cotegory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-cotegory";
        }

        cotegoryRepository.save(cotegory);
        model.addAttribute("cotegorys", cotegoryRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatecotegory/{id}")
    public String updateCotegory(@PathVariable("id") int id, @Valid Cotegory cotegory, BindingResult result, Model model) {
        if (result.hasErrors()) {
            cotegory.setId(id);
            return "update-cotegory";
        }

        cotegoryRepository.save(cotegory);
        model.addAttribute("cotegorys", cotegoryRepository.findAll());
        return "redirect:/";
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newsupplier")
    public String showSignUpFormSupplier(Model model) {
        model.addAttribute("supplier",new Supplier());
        return "add-supplier";
    }


    @GetMapping("/editsupplier/{id}")
    public String showUpdateFormSupplier(@PathVariable("id") int id, Model model) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:" + id));
        model.addAttribute("supplier", supplier);
        return "update-supplier";
    }

    @GetMapping("/deletesupplier/{id}")
    public String deleteSupplier(@PathVariable("id") int id, Model model) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:" + id));
        supplierRepository.delete(supplier);
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addsupplier")
    public String addSupplier(@Valid Supplier supplier, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-supplier";
        }

        supplierRepository.save(supplier);
        model.addAttribute("suppliers", supplierRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatesupplier/{id}")
    public String updateSupplier(@PathVariable("id") int id, @Valid Supplier supplier, BindingResult result, Model model) {
        if (result.hasErrors()) {
            supplier.setId(id);
            return "update-supplier";
        }

        supplierRepository.save(supplier);
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "redirect:/";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newwarehouse")
    public String showSignUpFormWarehouse(Model model) {
        model.addAttribute("warehouse",new Warehouse());
        return "add-warehouse";
    }


    @GetMapping("/editwarehouse/{id}")
    public String showUpdateFormWarehouse(@PathVariable("id") int id, Model model) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid warehouse Id:" + id));
        model.addAttribute("warehouse", warehouse);
        return "update-warehouse";
    }

    @GetMapping("/deletewarehouse/{id}")
    public String deleteWarehouse(@PathVariable("id") int id, Model model) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid warehouse Id:" + id));
        warehouseRepository.delete(warehouse);
        model.addAttribute("warehouses", warehouseRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addwarehouse")
    public String addWarehouse(@Valid Warehouse warehouse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-warehouse";
        }

        warehouseRepository.save(warehouse);
        model.addAttribute("warehouses", warehouseRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatewarehouse/{id}")
    public String updateWarehouse(@PathVariable("id") int id, @Valid Warehouse warehouse, BindingResult result, Model model) {
        if (result.hasErrors()) {
            warehouse.setId(id);
            return "update-warehouse";
        }

        warehouseRepository.save(warehouse);
        model.addAttribute("warehouses", warehouseRepository.findAll());
        return "redirect:/";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newelectronics")
    public String showSignUpFormElectronics(Model model) {
        model.addAttribute("electronics",new Electronics());
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("cotegorys", cotegoryRepository.findAll());
        return "add-electronics";
    }


    @GetMapping("/editelectronics/{id}")
    public String showUpdateElectronics(@PathVariable("id") int id, Model model) {
        Electronics electronics = electronicsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid electronics Id:" + id));
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("cotegorys", cotegoryRepository.findAll());
        model.addAttribute("electronics", electronics);
        return "update-electronics";
    }

    @GetMapping("/deleteelectronics/{id}")
    public String deleteElectronics(@PathVariable("id") int id, Model model) {
        Electronics electronics = electronicsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid electronics Id:" + id));
        electronicsRepository.delete(electronics);
        model.addAttribute("electronicss", electronicsRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addelectronics")
    public String addElectronics(@ModelAttribute("warehouseid") int warehouseid, @ModelAttribute("cotegoryid") int cotegoryid, @Valid Electronics electronics, BindingResult result, Model model) {
        Warehouse warehouse = warehouseRepository.findById(warehouseid).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:"));
        Cotegory cotegory = cotegoryRepository.findById(cotegoryid).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:"));
        electronics.setWarehouse(warehouse);
        electronics.setCotegory(cotegory);

        electronicsRepository.save(electronics);
        model.addAttribute("electronicss", electronicsRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updateelectronics/{id}")
    public String updateElectronics(@PathVariable("id") int id, @ModelAttribute("warehouseid") int warehouseid, @ModelAttribute("cotegoryid") int cotegoryid, @Valid Electronics electronics, BindingResult result, Model model) {
        Warehouse warehouse = warehouseRepository.findById(warehouseid).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" + id));
        Cotegory cotegory = cotegoryRepository.findById(cotegoryid).orElseThrow(() -> new IllegalArgumentException("Invalid manufacturer Id:" + id));
        electronics.setWarehouse(warehouse);
        electronics.setCotegory(cotegory);
        electronicsRepository.save(electronics);
        model.addAttribute("electronicss", electronicsRepository.findAll());
        return "redirect:/";
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newcantract")
    public String showSignUpFormCantract(Model model) {
        model.addAttribute("cantract",new Cantract());
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        return "add-cantract";
    }


    @GetMapping("/editcantract/{id}")
    public String showUpdateCantract(@PathVariable("id") int id, Model model) {
        Cantract cantract = cantractRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cantract Id:" + id));
        model.addAttribute("warehouses", warehouseRepository.findAll());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("cantracts", cantract);
        return "update-cantract";
    }

    @GetMapping("/deletecantract/{id}")
    public String deleteCantract(@PathVariable("id") int id, Model model) {
        Cantract cantract = cantractRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid cantract Id:" + id));
        cantractRepository.delete(cantract);
        model.addAttribute("cantracts", cantractRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addcantract")
    public String addCantract(@ModelAttribute("warehouseid") int warehouseid, @ModelAttribute("supplierid") int supplierid, @Valid Cantract cantract, BindingResult result, Model model) {
        Warehouse warehouse = warehouseRepository.findById(warehouseid).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:"));
        Supplier supplier = supplierRepository.findById(supplierid).orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:"));
        cantract.setWarehouse(warehouse);
        cantract.setSupplier(supplier);

        cantractRepository.save(cantract);
        model.addAttribute("cantracts", cantractRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatecantract/{id}")
    public String updateCantract(@PathVariable("id") int id, @ModelAttribute("warehouseid") int warehouseid, @ModelAttribute("supplierid") int supplierid, @Valid Cantract cantract, BindingResult result, Model model) {
        Warehouse warehouse = warehouseRepository.findById(warehouseid).orElseThrow(() -> new IllegalArgumentException("Invalid carbrend Id:" + id));
        Supplier supplier = supplierRepository.findById(supplierid).orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:" + id));
        cantract.setWarehouse(warehouse);
        cantract.setSupplier(supplier);
        cantractRepository.save(cantract);
        model.addAttribute("cantracts", cantractRepository.findAll());
        return "redirect:/";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/newsupply")
    public String showSignUpFormSupply(Model model) {
        model.addAttribute("supply",new Supply());
        model.addAttribute("cantracts", cantractRepository.findAll());
        return "add-supply";
    }


    @GetMapping("/editsupply/{id}")
    public String showUpdateSupply(@PathVariable("id") int id, Model model) {
        Supply supply = supplyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid supply Id:" + id));
        model.addAttribute("cantracts", cantractRepository.findAll());
        model.addAttribute("supplys", supply);
        return "update-supply";
    }

    @GetMapping("/deletesupply/{id}")
    public String deleteSupply(@PathVariable("id") int id, Model model) {
        Supply supply = supplyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid supply Id:" + id));
        supply.setCantract(null);
        supplyRepository.delete(supply);
        model.addAttribute("supplys", supplyRepository.findAll());
        return "redirect:/";
    }

    @PostMapping("/addsupply")
    public String addSupply(@ModelAttribute("cantractid") int cantractid, @Valid Supply supply, BindingResult result, Model model) {
        Cantract cantract = cantractRepository.findById(cantractid).orElseThrow(() -> new IllegalArgumentException("Invalid cantract Id:"));
        supply.setCantract(cantract);

        supplyRepository.save(supply);
        model.addAttribute("supplys", supplyRepository.findAll());

        return "redirect:/";
    }

    @PostMapping("/updatesupply/{id}")
    public String updateSupply(@PathVariable("id") int id, @ModelAttribute("cantractid") int cantractid, @Valid Supply supply, BindingResult result, Model model) {
        Cantract cantract = cantractRepository.findById(cantractid).orElseThrow(() -> new IllegalArgumentException("Invalid cantract Id:" + id));
        supply.setCantract(cantract);
        supplyRepository.save(supply);
        model.addAttribute("supplys", supplyRepository.findAll());
        return "redirect:/";
    }



}
