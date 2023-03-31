package com.example.qr_go.QR;

public class Avatar {
    private static final String[] FACE_SHAPES = {
            "  ( o_O )   ",
            "  ( o.o )  ",
            "  ( >.< )  ",
            " @( o_o )@  ",
            "  ( ._. )   ",
            "  ( Q_Q )   ",
            "  ( O O )   ",
            "  ( -_- )   ",
            "  ( ^_^ )   ",
            "  ( >_< )   ",
            "  (* > *)  "
    };

    private static final String[] BODY_FEATURES = {
            "  |   |  ",
            "  |===|  ",
            "  |___|  ",
            "  /   \\  ",
            "  [   ]  ",
            "  {   }  ",
            "  (   )  ",
            "  \\   /  ",
            "  | o |  ",
            "  / o \\  ",
            "  ) . (  "
    };

    private static final String[] LEG_FEATURES = {
            "/   \\",
            "|   |",
            "| | |",
            "\\___/",
            "|-|-|",
            "/ | \\",
            "|___|",
            "| . |",
            "\\   /",
            "|/|\\|",
            "|>|<|"
    };

    private static final String[] HAT_FEATURES = {
            "   ___   ",
            "  /   \\  ",
            "  \\___/  ",
            "  /___\\  ",
            "  \\___/  ",
            "   |||   ",
            "  (___)  ",
            "  [___]  ",
            "  _/ \\_  ",
            "  |^^^|  ",
            "  |_|_|_|  ",
            "  ooooo  "
    };

    private static final String[] SHOE_FEATURES = {
            "<_|_>",
            ">_|_<",
            "(_|_)",
            "[_|_]",
            "{_|_}",
            "\\_|_/",
            "....."
    };

    public String generateAvatar(String hash) {
        String hex = hash.substring(0, 10);

        String faceShape = FACE_SHAPES[Integer.parseInt(hex.substring(0, 2), 16) % FACE_SHAPES.length];
        String hat = HAT_FEATURES[Integer.parseInt(hex.substring(2, 4), 16) % HAT_FEATURES.length];
        String body = BODY_FEATURES[Integer.parseInt(hex.substring(4, 6), 16) % BODY_FEATURES.length];
        String legs = LEG_FEATURES[Integer.parseInt(hex.substring(6, 8), 16) % LEG_FEATURES.length];
        String shoes = SHOE_FEATURES[Integer.parseInt(hex.substring(8, 10), 16) % SHOE_FEATURES.length];

        int maxLength = Math.max(Math.max(faceShape.length(), hat.length()), Math.max(body.length(), Math.max(legs.length(), shoes.length())));

        int hatPadding = (maxLength - hat.length()) / 2;
        int facePadding = (maxLength - faceShape.length()) / 2;
        int bodyPadding = (maxLength - body.length()) / 2;
        int legsPadding = (maxLength - legs.length()) / 2;
        int shoesPadding = (maxLength - shoes.length()) / 2;

        String avatar = "";
        avatar += padString(hat, hatPadding) + "\n";
        avatar += padString(faceShape, facePadding) + "\n";
        avatar += padString(body, bodyPadding) + "\n";
        avatar += padString(legs, legsPadding) + "\n";
        avatar += padString(shoes, shoesPadding);

        return avatar;
    }

    private String padString(String str, int padding) {
        return " ".repeat(Math.max(0, padding)) + str;
    }
}