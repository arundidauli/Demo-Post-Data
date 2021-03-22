package com.wingshield.technologies.demopostdata.presentation.ui.uiInterface;

import com.wingshield.technologies.demopostdata.model.Users;

public interface UserListener {
    void delete(String id);
    void Update(Users users);
}
