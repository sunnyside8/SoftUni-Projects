package com.example.springmappingobjectsex.config;

import com.example.springmappingobjectsex.models.dtos.GameAddDto;
import com.example.springmappingobjectsex.models.dtos.UserGamesDto;
import com.example.springmappingobjectsex.models.entities.Game;
import com.example.springmappingobjectsex.models.entities.User;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ApplicationBeanConfiguration {


    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
//        Converter<List<Game>, List<String>> listGameConvertor = new Converter<List<Game>, List<String>>() {
//            @Override
//            public List<String> convert(MappingContext<List<Game>, List<String>> mappingContext) {
//                return mappingContext.getSource().stream().map(Game::getTitle).collect(Collectors.toList());
//            }
//        };

        modelMapper.typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper -> mapper.map(GameAddDto::getThumbnailURL,Game::setImageThumbnail));
//        modelMapper.typeMap(User.class, UserGamesDto.class)
//                .addMappings(mapper -> mapper.map(User::get,Game::setImageThumbnail));


       // modelMapper.addConverter(listGameConvertor);
        return modelMapper;
    }
}
