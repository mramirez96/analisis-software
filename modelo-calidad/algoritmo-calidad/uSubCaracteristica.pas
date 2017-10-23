unit uSubCaracteristica;

interface

uses
  uTipoClasificacion;

type

  TSubCaracteristica = class
  private
    FMala: Double;
    FRegular: Double;
    FBuena: Double;
    FNombre: string;
    FClasificacion: TTipoClasificacion;
  public
    property Clasificacion: TTipoClasificacion read FClasificacion write FClasificacion;
    property Nombre: string read FNombre write FNombre;

    constructor Create(ANombre: string; AMala, ARegular, ABuena: Double);
    function GetPonderacion: Double;
  end;

implementation

{ TSubCaracteristica }

constructor TSubCaracteristica.Create(ANombre: string;
  AMala, ARegular, ABuena: Double);
begin
  FMala := AMala;
  FRegular := ARegular;
  FBuena := ABuena;
  FNombre := ANombre;
  FClasificacion := tcBuena;
end;

function TSubCaracteristica.GetPonderacion: Double;
begin
  Result := 0;
  case Clasificacion of
    tcMala: Result := FMala;
    tcRegular: Result := FRegular;
    tcBuena: Result := FBuena;
  end;
end;

end.
