package com.musicreview.controller;

import com.musicreview.model.*;
import com.musicreview.service.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class MyController {

    private static final int DEFAULT_RECORDLABEL_ID = -1;


    private final UserService userService;


    private final ArtistService artistService;


    private final RecordLabelService recordLabelService;


    private final MusicReleaseService musicReleaseService;


    private final ReviewService reviewService;

    @Autowired
    public MyController(UserService userService, ArtistService artistService,
                        RecordLabelService recordLabelService,
                        MusicReleaseService musicReleaseService, ReviewService reviewService) {
        this.userService = userService;
        this.artistService = artistService;
        this.recordLabelService = recordLabelService;
        this.musicReleaseService = musicReleaseService;
        this.reviewService = reviewService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        CustomUser dbUser = userService.getUserByLogin(login);
        model.addAttribute("firstName", dbUser.getFirstName());
        model.addAttribute("secondName", dbUser.getLastName());
        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());
        model.addAttribute("email", dbUser.getEmail());

        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam(required = false) String email, @RequestParam(required = false) String phone) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        CustomUser dbUser = userService.getUserByLogin(login);
        dbUser.setEmail(email);

        userService.updateUser(dbUser);


        return "redirect:/";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String update(@RequestParam String firstName,
                         @RequestParam String secondName,
                         @RequestParam String login,
                         @RequestParam String password,
                         @RequestParam(required = false) String email,
                         Model model) {
        if (userService.existsByLogin(login)) {
            model.addAttribute("exists", true);
            return "register";
        }

        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String passHash = encoder.encodePassword(password, null);

        CustomUser dbUser = new CustomUser(firstName, secondName, login, passHash, UserRole.USER, email);
        userService.addUser(dbUser);

        return "redirect:/";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }

    @RequestMapping("/newartist")
    public String artist() {
        return "newartist";
    }

    @RequestMapping(value = "/newartist", method = RequestMethod.POST)
    public String addArtist(@RequestParam String artist_firstname,
                            @RequestParam String artist_secondname,
                            @RequestParam String artist_nickname, Model model) {
        if (artistService.existsByNickname(artist_nickname)) {
            model.addAttribute("exists", true);
            return "reject";
        }

        artistService.addArtist(new Artist(artist_firstname, artist_secondname, artist_nickname));

        return "redirect:/artist_list";
    }

    @RequestMapping("/remove/{id}")
    public String removeArtist(@PathVariable("id") Long id) {

        artistService.deleteArtist(id);

        return "redirect:/artist_list";
    }

    @RequestMapping(value = "artist_list", method = RequestMethod.GET)
    public String listArtist(Model model) {
        model.addAttribute("artist", new Artist());
        model.addAttribute("artistList", artistService.artistList());
        return "artist_list";
    }


    @RequestMapping("/newlabel")
    public String recordLabel() {
        return "newlabel";
    }

    @RequestMapping(value = "/newlabel", method = RequestMethod.POST)
    public String addRecordLabel(@RequestParam String label_name,
                                 @RequestParam String label_country, Model model) {
        if (recordLabelService.existsRecordLabelByName(label_name)) {
            model.addAttribute("exists", true);
            return "reject";
        }

        recordLabelService.addRecordLabel(new RecordLabel(label_name, label_country));

        return "redirect:/recordlabel_list";
    }

    @RequestMapping(value = "/recordlabel/add", method = RequestMethod.POST)
    public String groupAdd(@RequestParam String name) {
        artistService.recordLabelsListForArtist(new RecordLabel(name));
        return "redirect:/newartist";
    }


    @RequestMapping("/recordlabel/{id}")
    public String listGroup(@PathVariable(value = "id") long groupId, Model model) {
        RecordLabel recordLabel = (groupId != DEFAULT_RECORDLABEL_ID) ? artistService.findRecordLabel(groupId) : null;

        model.addAttribute("recordlabel", artistService.recordLabelsListForArtist(recordLabel));
        //     model.addAttribute("contacts", artistService.l(group));

        return "index";
    }

    @RequestMapping(value = "recordlabel_list", method = RequestMethod.GET)
    public String recordLabelList(Model model) {
        model.addAttribute("recordlabel", new RecordLabel());
        model.addAttribute("recordLabelList", recordLabelService.recordLabelList());
        return "recordlabel_list";
    }

    @RequestMapping("label/remove/{id}")
    public String removeRecordLabel(@PathVariable("id") Long id) {

        recordLabelService.deleteRecordLabel(id);

        return "redirect:/recordlabel_list";
    }

    @RequestMapping("/newreview")
    public String review() {
        return "newreview";
    }

    @RequestMapping(value = "/newreview", method = RequestMethod.POST)
    public String addReview(@RequestParam String review_name,
                            @RequestParam String review_rate,
                            @RequestParam String review_text,
//                            @RequestParam Long musicrelease_id,
                            Model model) {

        model.addAttribute(new Review());

        reviewService.addReview(new Review(review_name, review_text, Integer.parseInt(review_rate)
 //               ,                                reviewService.findMusicRelease(musicrelease_id)
        ));

        return "redirect:/review_list";
    }

    @RequestMapping(value = "review_list", method = RequestMethod.GET)
    public String reviewList(Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("reviewList", reviewService.reviewList());
        return "review_list";
    }

    @RequestMapping("review/remove/{id}")
    public String removeReview(@PathVariable("id") Long id) {

        reviewService.deleteReview(id);

        return "redirect:/review_list";
    }
}
