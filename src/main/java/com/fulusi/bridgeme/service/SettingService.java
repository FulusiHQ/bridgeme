package com.fulusi.bridgeme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.fulusi.bridgeme.constant.Status;
import com.fulusi.bridgeme.dao.SettingDao;
import com.fulusi.bridgeme.dto.*;
import com.fulusi.bridgeme.model.Setting;
import com.fulusi.bridgeme.constant.Message;

@Service
public class SettingService {

    @Autowired
    SettingDao settingDao;

    public MoResponse fetch(String name) {
        MoResponse moResponse = new MoResponse(Status.SUCCESS, Message.SUCCESS);
        if (name != null) {
            moResponse.setSetting(settingDao.findByName(name).get());
        } else {
            moResponse.setSettings(settingDao.findAll());
        }
        return moResponse;
    }

    public MoResponse insert(SettingRequest settingRequest) {
        MoResponse moResponse = new MoResponse(Status.SUCCESS, Message.SUCCESS);
        if (!settingDao.existsByName(settingRequest.getName())) {
            Setting setting = new Setting(settingRequest.getName(), settingRequest.getValue());
            moResponse.setSetting(settingDao.save(setting));
        }
        return moResponse;
    }

    public MoResponse update(SettingRequest settingRequest) {
        MoResponse moResponse = new MoResponse(Status.SUCCESS, Message.SUCCESS);
        if (settingDao.existsByName(settingRequest.getName())) {
            Update update = new Update().set("value", settingRequest.getValue()).currentDate("updatedAt");
            settingDao.updateSettingByName(settingRequest.getName(), update);
            moResponse.setSetting(settingDao.findByName(settingRequest.getName()).get());
        }
        return moResponse;
    }

    public MoResponse delete(SettingRequest settingRequest) {
        MoResponse moResponse = new MoResponse(Status.SUCCESS, Message.SUCCESS);
        delete(settingRequest.getName(), settingRequest.getVersion());
        return moResponse;
    }

    public boolean delete(String name, int version) {
        if (settingDao.existsByNameAndVersion(name, version)) {
            settingDao.deleteByNameAndVersion(name, version);
        }
        return true;
    }
}
