package com.algoritmos.algorithm;

import java.math.BigInteger;

public class Algorithm_Private_Key {
    public static void main(String[] args) {
        Algorithm_Euclides_Extended eg = new Algorithm_Euclides_Extended();

        // Ejercicio 11
        BigInteger modulus = new BigInteger(
                "00e7718262a7598295ebb4dd51989117373cea24c918c2522a397962c29486896894201fe216b3ae2c8dfe62ce7be8be351337173a14c73e32b43f1a96733b04de303e8e8d3ce60fa9e52fd1ab7622416578a53e33feb7a0e20653285528f38c6aa7dc4637383a914f40e5655852789c0a2b7f4f8e1a9decb51a0c44430ddff0ded85e7a75fcdb7a1cec539d0685e6b05664891d1627c7c213817e03f2e388f2d484b9313b7413db3e704aded473d4e727016ab8302cb620f0f4201872e69a43cce5f8f1de3e939c6958bcdd84a99b59b8b2b74e2061a5434b56b0f3ba5d62cff2c0d03bb4b8d0aed0403fced8ef373fb5f7b33bae9cb9870d2de73aa0085836a5517366241507ecdd7a95179e064ea2103da474f45b8539e7649f8ad5d2a7ff3a83ce50040b48a870fde3272a3355399f397997467fc636527465eea7ba6f3e332245b1ad286e4692d9bfa5b7fdfd273f2e9bc9fd62d6bcce18b1b1ce1776665b03a2fba2be318240e1c74b3e86965d444c17f3e897b1b19190c9deda0f107700976ef1795deeff394a8e06977f81cf66621a51646bcbac9e068beebe92a9370e760b7933fe6b7eb581d20f6b7aea7496c20ec606b89ffda8eeae767ca24e8fd735ecec2be14ff6b47bca491b2010f3f9a264c503eb32b18283109a2092b40e10d8167856c91945a03cbcfc28d1dab88417a32e02fe1bd580120ea23a0a7b305f",
                16);
        BigInteger prime1 = new BigInteger(
                "00fc9d5d6ff163c26fce3c2b13b2f8fa89543469132ba53527297af7116e2a8413d83bd57f9cbff50d0be41ebbcb38395cac8d48ee10264c3d93cf35451adb7d86ae1333bcfe70f27b9074aeb02f80f17beab08076a6b4dae4068bab19597eef38095164822c9e705b5453dc1076114623e7d58f508b0909b25a34ba31e701bae2e9940842e7ec3f0f66006aef97fb957de289758b2dd35604dd4dfd2c280a15d0c0046b848be772738774e051d4d79dbb8a31d847fd415158c54321a5ec54c5db03bab410494c6bcf24583e83f1e8b3a34ab97128b5e16bbe1251e43ecc536ebce8c21ec3f41836b9c16b700686cf4f521ec1793b0cdc5445223727453ac37a97",
                16);
        BigInteger prime2 = new BigInteger(
                "00ea8b8344fba304af98863c8a34abf5939954f4ef5ad53d351abf272f7dd37d2abfd41176b9e09e5e904fdb1734519ac744386e80fd263dc7eeb7801d524917da3e0ca19052d4234737b4bdf8e27d52e3cf1c92873ef175764acd264fa25ab88dde4782e084131770617a1562ef991a10239f81b52e4272289431dcae38df2cf8d263e1fd156e25e02ac625ef85a7c50bad986f54ddf535e56aaf66be5b08d5f9f4138e3e619752b3ba2f2011f1d97bc24859f7ab0b4653e536f365d9ab2b165aefc9d5b49f982f0d68f51b869da52a19bc81d8ce29c0fec2b7beb4f4b6ce7cfa11255f6ff96833ddc09774415f24857572704411066b41b8f41a01a762fe9979",
                16);
        BigInteger publicExponent = new BigInteger("65537");

        prime1 = prime1.subtract(new BigInteger("1"));
        prime2 = prime2.subtract(new BigInteger("1"));
        BigInteger phiN = prime1.multiply(prime2);

        BigInteger d = eg.euclidesEx(publicExponent, phiN);
        System.out.println("Private key 11: " + d.toString(16));

        System.out.println();
        // Ejercicio 12

        modulus = new BigInteger(
                "00c9fcfcf2a91145293661225c890541e5a22679e5b13badc17e31649d879aea074b3439d60879182583ba3c3509e233ded4ba64676c39459d5f539fc76af990b6a9322f8db14478e86aa7133badd7c85f3bdbbf3120255789852576e67f77c50136aa29f075ba140f4ef95bc6e1d1258f0fde99b59b6e92f27a32b88ff61b3c75f7a4412db3611be7669e6eb1e50d704a5292053eb7ac31ca48a927d423a2f45559f7e8280a9624c939167379adfcc0508f79283e06a8f83d3cc5296c1a0b69a49f1dd9bffb7e178aebb4fca75d8d19e02f65bc12c74c7a74de208460f60260bc2991842492f88f3eec6a963f5c6244c723",
                16);
        prime1 = new BigInteger(
                "00f4ca4d6222c3250c9ef20736615aa3b571b5dbddcfd978ef59919d58f1f1a045f015586cbe9064ea0b704bba7d384ea0f4bead89035ec7adecb4c06118577b6f084520575393ddbf38989e6272ac8774e3239ca62edf95239098aa130a4985c776e2d083db315b7fca6312629ef6295432d41d580b22be94c2f2a74468f02dff",
                16);
        prime2 = modulus.divide(prime1);
        publicExponent = new BigInteger("65537");

        prime1 = prime1.subtract(new BigInteger("1"));
        prime2 = prime2.subtract(new BigInteger("1"));
        phiN = prime1.multiply(prime2);

        d = eg.euclidesEx(publicExponent, phiN);
        System.out.println("Private key 12: " + d.toString(16));

    }

}
