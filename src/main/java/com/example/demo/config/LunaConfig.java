package com.example.demo.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Getter;

@Getter
@Configuration
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class LunaConfig {

    @Value("${Chrystoki.Chrystoki2.LibUNIX}")
    private String LibUNIX;

    @Value("${Chrystoki.Chrystoki2.LibUNIX64}")
    private String LibUNIX64;

    @Value("${Chrystoki.LunaSAClient.ClientPrivKeyFile}")
    private String ClientPrivKeyFile;

    @Value("${Chrystoki.LunaSAClient.ClientCertFile}")
    private String ClientCertFile;

    @Value("${Chrystoki.LunaSAClient.ServerCAFile}")
    private String ServerCAFile;

    @Value("${Chrystoki.LunaSAClient.NetClient}")
    private String NetClient;

    @Value("${Chrystoki.LunaSAClient.ServerName00}")
    private String ServerName00;

    @Value("${Chrystoki.LunaSAClient.ServerPort00}")
    private String ServerPort00;

    @Value("${Chrystoki.LunaSAClient.ServerName01}")
    private String ServerName01;

    @Value("${Chrystoki.LunaSAClient.ServerPort01}")
    private String ServerPort01;

    @Value("${Chrystoki.LunaSAClient.ServerName02}")
    private String ServerName02;

    @Value("${Chrystoki.LunaSAClient.ServerPort02}")
    private String ServerPort02;

    @Value("${Chrystoki.LunaSAClient.ServerName03}")
    private String ServerName03;

    @Value("${Chrystoki.LunaSAClient.ServerPort03}")
    private String ServerPort03;

    @Value("${Chrystoki.VirtualToken.VirtualToken00Label}")
    private String VirtualToken00Label;

    @Value("${Chrystoki.VirtualToken.VirtualToken00SN}")
    private String VirtualToken00SN;

    @Value("${Chrystoki.VirtualToken.VirtualToken00Members}")
    private String VirtualToken00Members;

    @Value("${Chrystoki.VirtualToken.VirtualToken01Label}")
    private String VirtualToken01Label;

    @Value("${Chrystoki.VirtualToken.VirtualToken01SN}")
    private String VirtualToken01SN;

    @Value("${Chrystoki.VirtualToken.VirtualToken01Members}")
    private String VirtualToken01Members;

    @Value("${Chrystoki.HASynchronize.uat_ha_slot}")
    private String haSyncUatHaSlot;

    @Value("${Chrystoki.HASynchronize.uat_db_ha_slot}")
    private String haSyncUatDbHaSlot;

    @Value("${Chrystoki.HAConfiguration.haLogStatus}")
    private String haLogStatus;

    @Value("${Chrystoki.HAConfiguration.uat_ha_slotStandbyMembers}")
    private String uat_ha_slotStandbyMembers;

    @Value("${Chrystoki.HAConfiguration.uat_ha_db_slotStandbyMembers}")
    private String uat_ha_db_slotStandbyMembers;

    @Value("${Chrystoki.HAConfiguration.AutoReconnectedInterval}")
    private String AutoReconnectedInterval;

    @Value("${Chrystoki.htl}")
    private String serverHtl;


    public void writeConfigToFile(String filepath) throws IOException {
        String configContent = buildConfigContent();
        Files.write(Path.of(filepath), configContent.getBytes(), StandardOpenOption.CREATE);
    }


    private String buildConfigContent(){

        StringBuilder configBuilder = new StringBuilder();
        configBuilder.append("Chrystoki2 = {\n")
            .append("    LibUNIX = '").append(LibUNIX).append("';\n")
            .append("    LibUNIX64 = '").append(LibUNIX64).append("';\n")
            .append("}\n\n")
            .append("LunaSAClient = {\n")
            .append("    ClientPrivKeyFile = '").append(ClientPrivKeyFile).append("';\n")
            .append("    ClientCertFile = '").append(ClientCertFile).append("';\n")
            .append("    ServerCAFile = '").append(ServerCAFile).append("';\n")
            .append("    NetClient = '").append(NetClient).append("';\n")
            .append("    ServerName00 = '").append(ServerName00).append("';\n")
            .append("    ServerPort00 = '").append(ServerPort00).append("';\n")
            .append("    ServerHtl00 = '").append(serverHtl).append("';\n")
            .append("    ServerName01 = '").append(ServerName01).append("';\n")
            .append("    ServerPort01 = '").append(ServerPort01).append("';\n")
            .append("    ServerHtl01 = '").append(serverHtl).append("';\n")
            .append("    ServerName02 = '").append(ServerName02).append("';\n")
            .append("    ServerPort02 = '").append(ServerPort02).append("';\n")
            .append("    ServerHtl02 = '").append(serverHtl).append("';\n")
            .append("    ServerName03 = '").append(ServerName03).append("';\n")
            .append("    ServerPort03 = '").append(ServerPort03).append("';\n")
            .append("    ServerHtl03 = '").append(serverHtl).append("';\n")
            .append("}\n\n")
            .append("VirtualToken = {\n")
            .append("    VirtualToken00Label = '").append(VirtualToken00Label).append("';\n")
            .append("    VirtualToken00SN = '").append(VirtualToken00SN).append("';\n")
            .append("    VirtualToken00Members = '").append(VirtualToken00Members).append("';\n")
            .append("    VirtualToken01Label = '").append(VirtualToken01Label).append("';\n")
            .append("    VirtualToken01SN = '").append(VirtualToken01SN).append("';\n")
            .append("    VirtualToken01Members = '").append(VirtualToken01Members).append("';\n")
            .append("}\n\n")
            .append("HASynchronize = {\n")
            .append("    uat_ha_slot = '").append(haSyncUatHaSlot).append("';\n")
            .append("    uat_db_ha_slot = '").append(haSyncUatDbHaSlot).append("';\n")
            .append("}\n\n")
            .append("HAConfiguration = {\n")
            .append("    haLogStatus = '").append(haLogStatus).append("';\n")
            .append("    uat_ha_slotStandbyMembers = '").append(uat_ha_slotStandbyMembers).append("';\n")
            .append("    uat_ha_db_slotStandbyMembers = '").append(uat_ha_db_slotStandbyMembers).append("';\n")
            .append("    AutoReconnectedInterval = '").append(AutoReconnectedInterval).append("';\n")
            .append("}\n");

        return configBuilder.toString();
    }
}
