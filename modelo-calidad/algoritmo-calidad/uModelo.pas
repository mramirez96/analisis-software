unit uModelo;

interface

uses
  System.Generics.Collections, uSubCaracteristica, uCalculo;

type

  TModelo = class
  private
    FSubCaracteristicas: TList<TSubCaracteristica>;
    FCalculo: TCalculo;
  public
    property SubCaracteristicas: TList<TSubCaracteristica> read FSubCaracteristicas write FSubCaracteristicas;

    constructor Create;
    procedure AgregarAlModelo(ANombre: string; AMala, AReg, ABuena: Double);
    function GetSubCaracteristicaByNombre(ANombre: string): TSubCaracteristica;
    function GetPromedioCalculado: Double;
  end;

implementation

{ TModelo }

procedure TModelo.AgregarAlModelo(ANombre: string; AMala, AReg,
  ABuena: Double);
begin
  FSubCaracteristicas.Add(TSubCaracteristica.Create(ANombre, AMala, AReg, ABuena));
end;

constructor TModelo.Create;
begin
  FSubCaracteristicas := TList<TSubCaracteristica>.Create;
  FCalculo := TCalculo.Create;
end;

function TModelo.GetPromedioCalculado: Double;
begin
  Result := FCalculo.PromedioObtenido(FSubCaracteristicas);
end;

function TModelo.GetSubCaracteristicaByNombre(
  ANombre: string): TSubCaracteristica;
var
  LItem: TSubCaracteristica;
begin
  Result := nil;
  for LItem in FSubCaracteristicas do
  begin
    if LItem.Nombre = ANombre then
      Result := LItem;
  end;
end;

end.
