{
    description = "DevShell";

    outputs = {flake-parts, ...} @ inputs: flake-parts.lib.mkFlake { inherit inputs; } {
        perSystem = { system, pkgs, ... }: {
            devShells.default = pkgs.mkShellNoCC {
                nativeBuildInputs = with pkgs; [
                    bruno
                ];
            };
        };

        systems = [ "x86_64-linux" "aarch64-linux" "x86_64-darwin" "aarch64-darwin" ];
    };

    inputs = {
        nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable";
        flake-parts.url = "github:hercules-ci/flake-parts";
    };
}
