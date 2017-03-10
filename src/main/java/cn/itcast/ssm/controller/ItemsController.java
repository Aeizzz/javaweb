package cn.itcast.ssm.controller;


import cn.itcast.ssm.dao.Items;
import cn.itcast.ssm.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by hong-ll on 2017/3/5.
 */
@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    //查询所有的items
    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception{
        List<Items> list = itemsService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("List",list);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }

    //根据id查询items
    @RequestMapping("/editItems")
    public String editItems(Model mode,Integer id)throws Exception{
        Items item = itemsService.findItemById(id);
        mode.addAttribute("items",item);
        return "editItem";
    }




    //修改信息
    @RequestMapping("/editItemSubmit")
    public String editItemSubmit(Model model, Integer id,Items items,MultipartFile pictureFile)throws
            Exception{
        if(pictureFile!=null){
            String path = "G:\\pic\\";
            String originalFilename = pictureFile.getOriginalFilename();
            String newName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
            File file = new File(path+newName);
            pictureFile.transferTo(file);
            items.setPic(newName);
        }
        itemsService.updateItems(id,items);
        return "editItem";
    }



    @RequestMapping("/viewItems/{id}")
    public @ResponseBody Items viewItems(@PathVariable("id") Integer id)throws Exception{

        Items item = itemsService.findItemById(id);



        return item;
    }




}
